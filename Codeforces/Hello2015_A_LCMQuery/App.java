import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class App {
	
	public static PrintWriter out;
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] array = new int[n];
		for(int i = 0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		while(m>0) {
			int x = sc.nextInt(); // How many elements you wish to calculate the lcm of.
			                      
			int range = n - x + 1; // Wherever in the array you wish to start from. 
			
			int result = Integer.MAX_VALUE;
			
			for(int i = 0;i<range;i++) {
				result = Math.min(result,lcm(array,i,i+x-1));
			}
			
			
			out.println(result % (100000007));
			
			m--;
		}
		
		out.close();

	}

	private static int lcm(int[] array, int i, int j) {
		
		int result = array[i];
		for(int k = i;k<=j;k++) {
			result = lcm(result,array[k]);
			
			
		}
		
		return result;
		
		
	}
	private static int lcm(int a, int b) {
		return a*b / hcf(a,b);
	}
	
	private static int hcf(int a, int b) {
		// Euclid's Algorithm
		// The idea is that the hcf of two numbers does no change if the larger number is replaced by its difference with the smaller number.
		while(b>0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	private static int hcf(int[] input) {
		int a = input[0];
		for(int i = 0;i<input.length;i++) {
			a = hcf(a,input[i]);
		}
		return a;
	}

}

class MyScanner{
	BufferedReader br;
	StringTokenizer st;
	
	public MyScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	int nextInt() {
		return Integer.parseInt(next());
	}
	long nextLong() {
		return Long.parseLong(next());
	}
	double nextDouble() {
		return Double.parseDouble(next());
	}
	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

