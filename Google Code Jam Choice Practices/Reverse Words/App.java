import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class App {
	private static String fileName = "Reverse Words/B-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		while( N > 0){
			
			String result = reverseWords(br.readLine().split("\\s+"));
			
			
			
			bw.write(String.format("Case #%d: %s", i, result));
			bw.newLine();
			i++;
			N--;
		}
		
		
		
		
		
		
		br.close();
		bw.close();
	}


	private static String reverseWords(String[] split) {
		StringBuilder s = new StringBuilder();
		for(int i = 0;i < split.length;i++){
			s.append(split[split.length-1-i]);
			s.append(" ");
		}
		
		return s.toString();
	}

}
