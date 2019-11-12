package com.vignesh.java_playground.concurrent;

import java.lang.Thread.State;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void testMethods() {
		Thread t = new Thread(() -> {
			System.out.println("Run");
		});
		t.start();
		State state = t.getState();
		System.out.println("state.name() : " + state.name());
	}
	
	@Test
	public void testUnCoughtExceptionHandler() {
		Thread t = new Thread(() -> {
			System.out.println("Run");
			throw new UnsupportedOperationException();
		});
		t.setUncaughtExceptionHandler((th,ex) -> {
			System.out.println("Exception : "+ex+" thrown from Thread : "+th.getName());
		});
		t.start();
	}
}
