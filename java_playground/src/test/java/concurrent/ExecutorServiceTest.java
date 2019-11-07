package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class ExecutorServiceTest {

	@Test
	public void testStaticMethods() throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		String input = "submit";
		Future<String> future = es.submit(() -> {
			System.out.println("done");
		}, input);
		System.out.println(future.get());
	}
	
}
