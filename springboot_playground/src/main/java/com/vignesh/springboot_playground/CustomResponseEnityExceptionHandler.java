package com.vignesh.springboot_playground;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vignesh.springboot_playground.model.ErrorResponse;

@ControllerAdvice
public class CustomResponseEnityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		if (ex.getBindingResult().hasErrors()) {
			ex.getBindingResult().getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
		}
		return super.handleExceptionInternal(ex, response, headers, status, request);
	}

}
