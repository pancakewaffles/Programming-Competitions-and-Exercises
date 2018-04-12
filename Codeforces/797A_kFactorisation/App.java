import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class App {
	public static PrintWriter out;
	static int s = Integer.MIN_VALUE;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int n = sc.nextInt();
		int N = n;
		int k = sc.nextInt();
		int[] factors = new int[k];
		boolean sentinel = true;
		for(int i = 1;i<factors.length;i++){
			for(int j = 2;j<=n;j++) {
				if(n%j == 0) {
					n=n/j;
					factors[i] = j;
					break;
				}
				
			}
		}
		factors[0] = n;
		
		for(int i = 0;i<factors.length;i++) {
			if(factors[i] == 0 || factors[i] == 1) {
				sentinel = false;
			}
		}
		
		if(sentinel == true) {
			printArray(factors);
		}else {
			out.println(-1);
		}
		
			
		
		
		out.close();

	}
	private static void printArray(int[] factors) {
		for(int j = 0;j<factors.length;j++) {
			out.print(factors[j]+" ");
		}
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

