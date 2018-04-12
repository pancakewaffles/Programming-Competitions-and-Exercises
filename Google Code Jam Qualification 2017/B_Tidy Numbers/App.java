import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/*
 * There are two ways to solve this. 
 * One, using my naive method of checking each number from N to 1. This works for numbers like 1000 but not for numbers like 10000000000000.
 * 
 * Two, an efficient greedy approach.
 * This works like this:
 * Within N, find the first "inversion" i.e. the minimum i such that N_i > N_i+1. 
 * If there is no such i, then N is already tidy. Duh!
 * We simply need to work with this first "inversion" because the second "inversion" onwards will be dealt with automatically once we have dealt with the first inversion.
 * 
 * 
 * Our required number, therefore 
 * starts with N_1N_2N_3....N_i-1
 * next digit A_i < N_i, A_i = N_i - 1;
 * We must make sure that A_i >= A_i-1, to then proceed with just filling up 99999 for the rest of the number.
 * If A_i < A_i-1, then we recast the number as N_1N_2N_3...N_i-2, and check again.
 * 
 * E.g. 13254
 * Two inversions, 32 and 54. We only care about 32. 
 * Our required number,
 * starts with 1
 * next digit 2 instead of 3. 
 * 2 > 1, therefore we can just put 999999 for the rest.
 * Our required number = 12999.
 * 
 * E.g. 15542
 * Two inversions, 54 and 42. We only care about 54.
 * Our required number,
 * starts with 15
 * next digit 4 instead of 5.
 * But wait, 15 4 is invalid.
 * So, we backtrack.
 * Our required number,
 * starts with 1
 * next digit 4 instead of 5.
 * 4>1, therefore we just put 99999 for the rest.
 * Our required number = 14999.
 *
 * This runs in O(number of digits in N) = O(logN) 
 * 
 */
public class App {
	
	private static String fileName = "B_Tidy Numbers/B-large-practice.in";
	private static File inputFile = new File(fileName);
	private static BufferedReader br;
	private static BufferedWriter bw;


	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(inputFile)); 
		int T = Integer.parseInt(br.readLine());
		
		File outputFile = new File("B_Tidy Numbers/B-large-practice.out");
		bw = new BufferedWriter(new FileWriter(outputFile));
		int caseNumber = 1;
		while(caseNumber<=T) {
			
			System.out.println(String.format("Processing Case #%d", caseNumber));
			
			char[] N = br.readLine().toCharArray();
			long result = -1;
			
			// Where is the first inversion?
			for(int i = 0;i<N.length-1;i++) {
				if(N[i] > N[i+1]) {
					// First inversion at index i
					N = findTidy(N,i);
					break;
				}
	
			}
			
			result = Long.parseLong(new String(N));
			
			
			bw.write(String.format("Case #%d: %d",caseNumber,result));
			bw.newLine();
			
			
			caseNumber++;
			
		}
		
		
		
		br.close();
		bw.close();

	}



	private static char[] findTidy(char[] N, int i) {

		// Our first inversion is at index i.
		// Next, we search N_1...N_i-1 for an index j at which N_j = N_i
		// Then we use j as the new i.
		// See, we can't use N_i because decreasing N_i means we create an inversion where N_j > N_i, but this only happens if N_j = N_i in the first place.
		// We thus tackle j.
		for(int j = 0;j<i;j++) {
			if(N[j] == N[i]) {
				i = j;
				break; // We want to use the first N_j = N_i.
			}
		}
		N[i] =  Integer.toString((Character.getNumericValue(N[i]) - 1)).charAt(0);
		for(int a = i+1;a<N.length;a++) {
			N[a] = '9';
		}
		return N;
		
	}


	private static boolean isValid(long i) {
		
		/* Naive (Does not work)
		String[] ss = Long.toString(i).split("");
		int max = Integer.parseInt(ss[ss.length-1]);
		int min = Integer.parseInt(ss[0]);
		for(int j = 0;j < ss.length-1; j++ ) {
			if(Integer.parseInt(ss[j]) > max ) {
				return false;
			}
			if(Integer.parseInt(ss[j]) < min) {
				return false;
			}
			
		}
		return true;
		*/
		
		// Compares sorted array with number; takes too long
		
		long temp = i;
		
		ArrayList<Long> array = new ArrayList<Long>();
		while(temp>0) {
			array.add(temp/10);
			temp = temp/10;
		}
		
		Collections.sort(array);
		String[] ss = Long.toString(i).split("");
		for(int j = 0;j<ss.length;j++) {
			if(Integer.parseInt(ss[j]) != array.get(j)) {
				return false;
			}
		}
		return true;
		
		

		
		
	}

}

