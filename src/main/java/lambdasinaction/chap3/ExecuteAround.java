package lambdasinaction.chap3;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ExecuteAround {

	public static void main(String ...args) throws IOException, URISyntaxException {

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException, URISyntaxException {
//		System.out.println();

		//通过全路径
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader("src/main/resources/lambdasinaction/chap3/data.txt"))) {
//            return br.readLine();
//        }
		//通过classloader
		String path=ExecuteAround.class.getClassLoader().getResource("lambdasinaction/chap3/data.txt"	).toURI().getPath();
		try(BufferedReader br=new BufferedReader(new FileReader(path))){
			return br.readLine();
		}
		//通过inputStreamReader
//		try(InputStreamReader input =new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("lambdasinaction/chap3/data.txt")));
//			BufferedReader br=new BufferedReader(input)){
//			return br.readLine();
//		}
    }


	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lambdasinaction/chap3/data.txt"))){
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
