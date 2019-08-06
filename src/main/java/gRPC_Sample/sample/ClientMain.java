package gRPC_Sample.sample;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClientMain {
	private static ExecutorService executorService;

	private static int threadCount = 3;
//	private static String fileName = "testfile_300m_";
	private static String fileName = "text_400m_";

	public static void main(String[] args) throws InterruptedException, IOException {

		long start = System.currentTimeMillis();
		System.out.println("Start :" + start);

		executorService = Executors.newFixedThreadPool(threadCount);

		for(int i = 0; i < threadCount; i++) {
			executorService.submit(new ClientThread(fileName + (i + 1) + ".txt"));
		}

		try {
			executorService.shutdown();
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("End : " + end);

		double elapsed = (double) (start - end) / 1000;

		System.out.println("Elapsed : " + elapsed + " sec");

	}
}
