package gRPC_Sample.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDiv {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String path = "C:\\Users\\kanatani\\Desktop\\a.txt";

		int data = 0;
		int count = 0;
		int MB = 4194304;
//		byte[] bytes = new byte[MB];

		File file = new File(path);
//		byte[] read = Files.readAllBytes(Paths.get(path));
//		System.out.println(new String(read, "SJIS"));

//		List<Byte> by = new ArrayList<>();
		long fileSize = Files.size(Paths.get(path));

		long loopCount = fileSize / MB;
		int rem = (int) (fileSize %  MB);
		boolean hasRem = rem > 0;

		if(hasRem) {
			loopCount += 1;
		}

		try(FileInputStream input = new FileInputStream(new File(path))) {


//			while((data = input.read(bytes, count, count + MB)) != -1) {
////				byte[] bytes = new byte[MB];
////				data = input.read(bytes, count, count + MB);
//
//
//				System.out.println(new String(bytes, "UTF-8"));
//				bytes = new byte[MB];
//			}


			for(int i = 0; i < loopCount; i++) {

				int byteLength = (i + 1 != loopCount) ? MB : rem;

				byte[] bytes = new byte[byteLength];
				data = input.read(bytes);
				System.out.println(new String(bytes, "UTF-8"));
//				count += byteLength;
			}


//			byte[] a = by.stream().toArray();

//			while(data != -1) {
//
////				byte[] bytes = new byte[MB];
//				data = input.read(bytes);
//				if(data != -1) {
//					System.out.println(new String(bytes, "SJIS"));
//				}
//
//
//			}


			System.out.println("File loaded");

		}
	}

}
