import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * So, let n/1000 be the needed concentration and s1,s2,...sk be the concentration of the different types we will use.
 * Let a1,a2,a3...ak be the weights of s1,s2,...sk respectively.
 * So,  (a1s1 + a2s2 + a3s3 + a4s4...aksk ) / ( 1000 * m ) = n /1000
 *  a1s1 + a2s2 + ... aksk = n * m
 *  
 *  m is the total number of types used. i.e. m = a1 + a2 + a3... ak
 *  
 *  Doesn't this remind you of the knapsack problem? Let m[w] be the m value that satisfies w = n*m
 *  So if I have a required concentration n, I will vary m, such that n*m = w, and compare all values of m[w] to find the minimum.
 *  m[w] = 1 + m[w-si] => so I have to iterate the k concentrations for each w.
 *  
 *  O(w*k) pseudo-polynomial
 *  
 *  
 *
 */
public class App {
	public static PrintWriter out;
	public static int[] m_values;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		// It turns out my knapsack idea was on point, but my implementation was bs.
		
		//myCrappyKnapsack(sc);
		
		/*Debugging for my CrappyKnapsack
		out.println("=======DEBUGGING=======");
		for(int i = 0;i<m_values.length;i++) {
			out.print(m_values[i] + " ");
		}
		out.println();
		
		out.println(m_values[3550]);
		*/
		
		// So here's how it should have been done.
		TaskC solver = new TaskC();
		solver.solve(sc,out);
		
		
		
	
		out.close();
	}
	private static void myCrappyKnapsack(MyScanner sc) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] cokeConcentration = new int[k];
		for(int i = 0;i<k;i++) {
			cokeConcentration[i] = sc.nextInt();
		}
		
		m_values = new int[1000001];
		Arrays.fill(m_values, -1);
		m_values[0] = 0;
		
		if(pretests(n,k,cokeConcentration) == true) { //Doing some pretests checks to speed up 
			dp(cokeConcentration,n,k);
			
			int min = Integer.MAX_VALUE;
			for(int m = 1; n*m <= m_values.length; m++) {
				if( m_values[n*m] > 0 && (m_values[n*m] == m) ) {
				min = Math.min(min, m_values[n*m]);
				}
			}
			if(min != Integer.MAX_VALUE) {
				out.println(min);
			}else {
				out.println(-1);
			}
			
			
		}
	}
	private static boolean pretests(int n, int k, int[] cokeConcentration) {
		/* Checks for several things:
		 * Is n bigger than all the concentrations? If so, it's an easy -1.
		 * Is n = any of the concentrations? If so, it's an easy 1.
		 * Is n = 0? If so, it's an easy -1.
		*/
		int max = n;
		boolean check = false;
		for(int i = 0;i<k;i++) {
			max = Math.max(max, cokeConcentration[i]);
			if(cokeConcentration[i] == n) {
				check = true;
			}
		}
		if(check==true) {
			out.println(1);
			return false;
		}
		if(max == n) {
			out.println(-1);
			return false;
		}
		if(n == 0) {
			out.println(-1);
			return false;
		}
		

		
		return true;
		
	}
	// This method fills up the m_values table (DP at work)
	private static void dp(int[] cokeConcentration, int n, int k) {
		for(int i = 1;i<m_values.length;i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 0;j<k;j++) {
				if(isValid(i-cokeConcentration[j])) {
				 min = Math.min(min, 1 + m_values[i-cokeConcentration[j]] );
				}
			}
			if(min != Integer.MAX_VALUE) {
				m_values[i] = min;
			}
			
		}
		
	}
	private static boolean isValid(int concentration) {
		if(concentration >= 0 && m_values[concentration] != -1) {
			return true;
		}
		return false;
	}

}

class TaskC{
	/*
	 * The idea is to have an array of booleans for the different types of concentrations.
	 * If there are two types of concentration (50 and 100), then f[50] and f[100] will be true.
	 * Next we have what is similar to my pretests section in myCrappyKnapsack.
	 * We filter out several conditions that we can immediately have a solution to.
	 * These are:
	 *  1. If concentration n exists as one of the types of concentration provided, then return 1 because we can just choose that concentration.
	 *  2. If n is smaller than any concentration that we are given (there are no concentrations that are smaller than n) , or n is larger than any concentration that we are given ( there are no concentrations that are greater than n), return -1.
	 */
	final int infinity = 1000000000;
	
	public void solve(MyScanner sc, PrintWriter out) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		final int N = 1000;
		
		boolean[] f = new boolean[N+1]; // This is the array of booleans for the different types of concentrations.
		
		for(int i = 0;i<k;i++) {
			int a = sc.nextInt(); 
			f[a] = true;
		}
		
		if(f[n]) { // Condition 1
			out.println(1);
			return;
		}
		int[] a = extractPositive(n,f);
		int[] b = extractNegative(n,f);
		if(a.length == 0 || b.length == 0) { // Condition 2
			out.println(-1);
			return;
		}
		
		int ans = infinity;
		int[] da = knapsack(a, N*N + 1);
		int[] db = knapsack(b, N*N + 1);
		for(int i = 1;i<da.length;i++) {
			ans = Math.min(ans, da[i] + db[i]);
		}
		out.println(ans);
	}

	private int[] knapsack(int[] a, int k) {
		int[] d = new int[k]; // This is your dynamic programming array, in which you fill the next value with a function of the previous values.
		Arrays.fill(d, infinity);
		d[0] = 0;
		for(int x : a) {
			for(int i = 0; i+x < k; i++) {
				d[i+x] = Math.min(d[i+x], d[i]+1);
			}
		}
		return d;
		
	}

	private int[] extractNegative(int n, boolean[] f) {
		// How many types of concentration that we were given are less than n?
		// Then extract them.
		// Well, extract their differences.
		int p = 0;
		for(int i = 0;i<n;i++) {
			if(f[i]) {
				p++;
			}
		}
		int[] a = new int[p];
		p = 0;
		for(int i = 0;i<n;i++) {
			if(f[i]) {
				a[p] = n-i;
				p++;
			}
		}
		return a;
	}

	private int[] extractPositive(int n, boolean[] f) {
		// How many types of concentration that we were given are greater than n?
		// Then extract them.
		// Well, extract their differences.
		int p = 0;
		for(int i = n+1;i<f.length;i++) {
			if(f[i] == true) {
				p++;
			}
		}
		int[] a = new int[p];
		p = 0;
		for(int i = n+1;i<f.length;i++) {
			if(f[i] == true) {
				a[p] = i-n;
				p++;
			}
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
