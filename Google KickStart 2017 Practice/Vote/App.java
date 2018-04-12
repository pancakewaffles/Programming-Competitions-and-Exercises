import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.LinkedList;

public class App {
	private static String fileName = "Vote/B-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br;
	private static BufferedWriter bw;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		//System.out.println( new BigDecimal(BigInteger.valueOf(1)).divide(new BigDecimal(BigInteger.valueOf(3)),5,RoundingMode.HALF_UP) );
		//System.out.println("sdad"+'d');
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		
		int T = Integer.parseInt(br.readLine());
		int caseNo = 1;
		
		while(T>0){
			System.out.println("Solving Case Number : " + caseNo);
			String[] s = br.readLine().split("\\s+");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			
			BigDecimal prob = count(N,M);
			
			
			bw.write(String.format("Case #%d: %s", caseNo,prob.toPlainString() ));
			bw.newLine();
			

			
			caseNo++;
			T--;
			count = 0;
			
		}
		
		
		
		br.close();
		bw.close();

	}
	
	private static BigDecimal count(int n, int m) {
		
		
		String s = "";
		BigInteger total = factorial(n+m);
		BigInteger switch_n_positions = factorial(n);
		BigInteger switch_m_positions = factorial(m);
		
		if(m == 0) {
			return new BigDecimal(BigInteger.ONE);
		}
		
		
		countUtil(s,n,m);

		
		
		
		
		
		
		
		return new BigDecimal(BigInteger.valueOf(count).multiply(switch_m_positions).multiply(switch_n_positions)).divide(new BigDecimal(total) , 10 , RoundingMode.HALF_UP);
		
		
	}

	private static boolean countUtil(String s, int n, int m) {
		
		
		if(m == 0 ) {
			count++;
			return true;
		}
		
		if(isSafe( s+ 'B') && m != 0) {
			m = m-1;
			s = s + 'B';
			
			countUtil(s,n,m);
				
			
			
			m = m + 1;
			s= s.substring(0, s.length()-1);
		}
		if(n != 0) {
		n = n -1;
		s = s + 'A';
		countUtil(s,n,m);
		}
		
		return false;
		
		
		
		
		
		
		
	}

	public static BigInteger factorial(int b) {
		BigInteger factorial = BigInteger.ONE;
		
		for(int i = b; i > 0;i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
			
		}
		return factorial;
	}
	
	public static int countLetters(char letter, String s) {
		int count = 0;
		for(int i = 0 ;i<s.length();i++) {
			if(s.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}
	public static boolean isSafe(String s) {
		if(countLetters('A',s) > countLetters('B',s)) {
			return true;
		}
		else { return false;}
	}

}
