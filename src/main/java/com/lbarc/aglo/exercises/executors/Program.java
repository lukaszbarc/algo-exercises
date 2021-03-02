package com.lbarc.aglo.exercises.executors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {

	private static Random random = new Random();

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(16);

		for (int i = 0; i < 1000; i++) {
			int finalI = i;
			executorService.submit(() -> {
				try {
					System.out.println("Thread " + finalI + " started");
					Thread.sleep(random.nextInt(10_000));
					System.out.println("Thread " + finalI + " finished");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		executorService.awaitTermination(10, TimeUnit.MINUTES);
	}

}
