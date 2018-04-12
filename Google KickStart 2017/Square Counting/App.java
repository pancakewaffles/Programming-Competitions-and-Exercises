import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class App {
	
	private static String fileName = "Square Counting/A-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		
		
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		int T = Integer.parseInt(br.readLine());
		int caseNo = 1;
		
		SquareCount sqCount = new SquareCount();
		
		while(T>0){
			
			String[] s = br.readLine().split("\\s+");
			int R = Integer.parseInt(s[0]);
			int C = Integer.parseInt(s[1]);
			
			
			long answer = sqCount.count(R, C);
			long result = answer % 1000000007;
			
			bw.write(String.format("Case #%d: %d", caseNo, result  ));
			bw.newLine();
			

			
			caseNo++;
			T--;
			
		}
		
		br.close();
		bw.close();

	}
	

}

class SquareCount{
	
	
	public SquareCount(){
		
		
	}
	long count(int R, int C) {
		
		long square = 0;
		
		if(R > C) {
			int temp = R;
			R = C;
			C = temp;
		}
		
		for(int i = 1;i < R;i++) {
			square += (long) (R-i) * (C-i);
			for(int j = 1;j< R;j++) {
				if(i + j  > R) {
					break;
					
				}
				else {
					square += (long) (R-i-j)*(C-i-j);
				}
			}
		}
		
		return square;
		
	}
	 
	 
}
