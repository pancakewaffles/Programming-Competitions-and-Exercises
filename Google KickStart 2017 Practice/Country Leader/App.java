import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
	private static String fileName = "Country Leader/A-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br;
	private static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		//Debug
		//AlphabetCounter ss = new AlphabetCounter("AGEOICCFQQQ");
		//System.out.println(ss.count());
		
		int T = Integer.parseInt(br.readLine());
		int caseNo = 1;
		
		while(T>0){
			System.out.println(String.format("Case #%d", caseNo));
			System.out.println();
			
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<String> names = new LinkedList<String>();
			LinkedList<Integer> count_results = new LinkedList<Integer>();
			
			for(int i = 0;i<N;i++) {
				String name = br.readLine();
				
				 AlphabetCounter ac = new AlphabetCounter(name);
				
				//Debug
				System.out.println(name + " has " + ac.count() + " unique alphabets.");
				
				
				
				names.addLast(name);
				count_results.addLast(ac.count());
				
				
			}
			
			int max = -1;
			int index = -1;
			for(int i = 0;i<count_results.size();i++) {
		
				if(count_results.get(i) > max) {
					//Debug
					System.out.println(names.get(i) + " 's number of unique characters exceeds the current max of "+ max + " with its " + count_results.get(i) + " number of unique characters." );
					max = count_results.get(i);
					index = i;
					
				}else if(count_results.get(i) == max) {
					if(names.get(i).compareTo(names.get(index)) < 0) {
						//Debug
						System.out.println(names.get(i) +" has the same amount of unique alphabets as "+names.get(index) +" but it is alphabetically earlier than "+ names.get(index));
						max = count_results.get(i);
						index = i;
					}
					
				}
				
			}
			
			
			
			bw.write(String.format("Case #%d: %s", caseNo, names.get(index) ));
			bw.newLine();
			

			
			caseNo++;
			T--;
			
		}
		
		br.close();
		bw.close();

	}

}

class AlphabetCounter {
	private String name;
	private boolean[] alphabetsArray;
	private HashMap<Character,Integer> alphabets_to_index;
	
	public AlphabetCounter(String name) {
		this.name = name;
		alphabetsArray = new boolean[26];
		Arrays.fill(alphabetsArray, false);
		alphabets_to_index = new HashMap<Character,Integer>();
		
		alphabets_to_index.put('A', 0);
		alphabets_to_index.put('B', 1);
		alphabets_to_index.put('C', 2);
		alphabets_to_index.put('D', 3);
		alphabets_to_index.put('E', 4);
		alphabets_to_index.put('F', 5);
		alphabets_to_index.put('G', 6);
		alphabets_to_index.put('H', 7);
		alphabets_to_index.put('I', 8);
		alphabets_to_index.put('J', 9);
		alphabets_to_index.put('K', 10);
		alphabets_to_index.put('L',	11);
		alphabets_to_index.put('M', 12);
		alphabets_to_index.put('N', 13);
		alphabets_to_index.put('O', 14);
		alphabets_to_index.put('P', 15);
		alphabets_to_index.put('Q', 16);
		alphabets_to_index.put('R', 17);
		alphabets_to_index.put('S', 18);
		alphabets_to_index.put('T', 19);
		alphabets_to_index.put('U', 20);
		alphabets_to_index.put('V', 21);
		alphabets_to_index.put('W', 22);
		alphabets_to_index.put('X', 23);
		alphabets_to_index.put('Y', 24);
		alphabets_to_index.put('Z', 25);
		
		
		
		
	}

	public Integer count() {
		int count = 0;
		for(int i = 0;i<name.length();i++){
			if(name.charAt(i) == ' ') {
				continue;
			}
			else{
				char c = name.charAt(i);
				if( alphabetsArray[alphabets_to_index.get(c)] == false) {
					alphabetsArray[alphabets_to_index.get(c)] = true;
					count++;
				}
			}
			
		}
		Arrays.fill(alphabetsArray, false);
		return count;
	}
}
