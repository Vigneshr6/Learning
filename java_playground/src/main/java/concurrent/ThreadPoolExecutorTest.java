package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 3, TimeUnit.SECONDS, queue);
		Future<String> submit = executor.submit(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Runnable in Thread - " + Thread.currentThread().getName());
				return "done";
			} catch (InterruptedException e) {
				e.printStackTrace();
				return "default";
			}
		});
		System.out.println("Result : "+submit.get());
		System.out.println("ThreadPool Shutdown");
	}
}
