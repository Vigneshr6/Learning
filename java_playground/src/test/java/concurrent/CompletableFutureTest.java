package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CompletableFutureTest {

	@Test
	public void testGetMethod() throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = new CompletableFuture<>();
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(() -> {
			try {
				Thread.sleep(3000);
				cf.complete("done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("result : " + cf.get());
	}

	@Test
	public void testRunAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("my runnable");
		});
		future.get(); // blocks until future completes
	}

	@Test
	public void testSupplyAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "done";
		});
		System.out.println("result of supplyasyn : " + future.get());
	}

	@Test
	public void testThenApply() throws InterruptedException, ExecutionException {
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "one";
		});

		// chaining async calls and return a result
		CompletableFuture<Integer> thenApply = supplyAsync.thenApply(s -> {
			return 1;
		});

		System.out.println("thenApply result : " + thenApply.get());
	}

	@Test
	public void testThenAccept() {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "one";
		}).thenAccept(s -> {
			// accepts future result
			System.out.println("Result : " + s);
		});
		future.join(); // waits till the thread terminates
	}

	@Test
	public void testThenRun() {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "one";
		}).thenRun(() -> {
			System.out.println("done");
		});
		future.join();
	}

	@Test
	public void testExceptionally() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
				throw new IllegalAccessError();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "one";
		}).thenApply(s -> {
			return s.toUpperCase();
		}).exceptionally(ex -> {
			System.out.println("exception : " + ex.getMessage());
			return "DefaultValue";
		});

		System.out.println("result : " + future.get());
	}
}
