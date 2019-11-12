package com.vignesh.java_playground.http;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vignesh.java_playground.model.SampleEntity;

public class HttpClientTest {

	private static final String HTTP_URL = "http://localhost:8080/dummy";
	private static final String HTTPS_URL = "https://reqres.in/api/users/2";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";
	private static ObjectMapper om;

	@BeforeClass
	public static void setup() {
		om = new ObjectMapper();
	}

	private String getJSONFromObject(Object o) throws JsonProcessingException {
		return om.writeValueAsString(o);
	}

	private <E> E getObjectFromString(String input, Class<E> type) throws IOException {
		return om.readValue(input,type);
	}

	private SampleEntity getSampleRequestBody() {
		return new SampleEntity("myname", 20);
	}

	private String getRequestJSON() throws JsonProcessingException {
		return getJSONFromObject(getSampleRequestBody());
	}

	private String readStream(InputStream in) throws IOException {
		StringBuilder resultBuilder = new StringBuilder();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		while ((line = br.readLine()) != null)
			resultBuilder.append(line);
		return resultBuilder.toString();
	}

	private void writeStream(OutputStream out,String msg) throws IOException {
		out.write(msg.getBytes());
		out.flush();
	}
	
	@Test
	public void testJavaHttpConnection() {
		try {
			URL url = new URL(HTTP_URL);
			HttpURLConnection getConnection = (HttpURLConnection) url.openConnection();
			int getResponseCode = getConnection.getResponseCode();
			System.out.println("status code : " + getResponseCode);
			String getResponseBody = readStream(getConnection.getInputStream());
			System.out.println("response body : " + getResponseBody);
			assertEquals(HttpStatus.OK.value(), getResponseCode);
			getConnection.disconnect();
			
			HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
			postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			postConnection.setDoOutput(true);
//			String reqBody = "{\"message\":\"this is a HttpURLConnection request\"}";

			writeStream(postConnection.getOutputStream(), getRequestJSON());

			System.out.println();
			System.out.println("POST");
			int postResponseCode = postConnection.getResponseCode();
			System.out.println("status code : " + postResponseCode);
			String postResponseBody = readStream(postConnection.getInputStream());
			SampleEntity responseEntity = getObjectFromString(postResponseBody, SampleEntity.class);
			System.out.println("response body : " + responseEntity);
			assertEquals(HttpStatus.CREATED.value(), postResponseCode);
			postConnection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJerseyClient() throws InterruptedException, ExecutionException, KeyManagementException, NoSuchAlgorithmException {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(HTTP_URL);
		Builder request = webTarget.request();

		System.out.println("GET");
		Response getResponse = request.get();
		System.out.println("status code : " + getResponse.getStatus());
		System.out.println("response body : " + getResponse.readEntity(String.class));
		assertEquals(HttpStatus.OK.value(), getResponse.getStatus());

//		request.header(CONTENT_TYPE, APPLICATION_JSON);

		System.out.println();
		System.out.println("POST");
		Response postResponse = request.post(Entity.entity(getSampleRequestBody(), MediaType.APPLICATION_JSON));
		System.out.println("status code : " + postResponse.getStatus());
		System.out.println("response body : " + postResponse.readEntity(SampleEntity.class));
		assertEquals(HttpStatus.CREATED.value(), postResponse.getStatus());
		
		System.out.println();
		System.out.println("ASYNC POST");
		AsyncInvoker async = request.async();
		Future<Response> postFutureResponse = async.post(Entity.entity(getSampleRequestBody(), MediaType.APPLICATION_JSON));
		Response asyncPostResponse = postFutureResponse.get();
		System.out.println("status code : " + asyncPostResponse.getStatus());
		System.out.println("response body : " + asyncPostResponse.readEntity(SampleEntity.class));
		assertEquals(HttpStatus.CREATED.value(), asyncPostResponse.getStatus());
		
		
		System.out.println();
		System.out.println("SSL Ignored GET");
		SSLContext ssl = SSLContext.getInstance("SSL");
		ssl.init(null, getX509TrustManagers(), null);
		WebTarget httpsTarget = client.target(HTTPS_URL);
		Response getResponse2 = httpsTarget.request().get();
		System.out.println("status code : " + getResponse2.getStatus());
		System.out.println("response body : " + getResponse2.readEntity(String.class));
		assertEquals(HttpStatus.OK.value(), getResponse2.getStatus());
	}

	private X509TrustManager[] getX509TrustManagers() throws NoSuchAlgorithmException, KeyManagementException {
		return new X509TrustManager[] { new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

			}
		} };
	}

	@Test
	public void testSpringRestTemplate() throws InterruptedException, ExecutionException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("GET");
		ResponseEntity<String> getResponse = restTemplate.getForEntity(HTTP_URL, String.class);
		System.out.println("status code : " + getResponse.getStatusCodeValue());
		System.out.println("response body : " + getResponse.getBody());
		assertEquals(HttpStatus.OK.value(), getResponse.getStatusCodeValue());

		System.out.println();
		System.out.println("POST");
		ResponseEntity<SampleEntity> postResponse = restTemplate.postForEntity(HTTP_URL, getSampleRequestBody(),
				SampleEntity.class);
		System.out.println("status code : " + postResponse.getStatusCodeValue());
		System.out.println("response body : " + postResponse.getBody());
		assertEquals(HttpStatus.CREATED.value(), postResponse.getStatusCodeValue());
		
		System.out.println();
		System.out.println("ASYNC POST");
		AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
		ListenableFuture<ResponseEntity<SampleEntity>> asyncPostResponseFuture = asyncRestTemplate.postForEntity(HTTP_URL, new HttpEntity<SampleEntity>(getSampleRequestBody()),
				SampleEntity.class);
		ResponseEntity<SampleEntity> asyncPostResponse = asyncPostResponseFuture.get();
		System.out.println("status code : " + asyncPostResponse.getStatusCodeValue());
		System.out.println("response body : " + asyncPostResponse.getBody());
		assertEquals(HttpStatus.CREATED.value(), asyncPostResponse.getStatusCodeValue());
	}

}
