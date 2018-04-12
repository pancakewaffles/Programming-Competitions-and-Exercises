import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App implements AutoCloseable{
	private static String fileName = "Store Credit/A-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File("Store Credit/A-large-practice.out");
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0;i<N;i++){
			int C = Integer.parseInt(br.readLine());
			int I = Integer.parseInt(br.readLine());
			int[] originalArray = new int[I];

			ArrayList<Integer> arrList = fillArrays(originalArray,br.readLine().split("\\s+"),I);
			
			Collections.sort(arrList);
			
			removeCostly(arrList,C);
			// Getting the items that meet the conditions
			int[] items = new int[2];
			outerloop:
			for(int j = 0;j<arrList.size();j++){
				for(int k = 0;k < arrList.size();k++){
					if(arrList.get(j) + arrList.get(k) == C && j != k){
						
						items[0] = arrList.get(j);
						items[1] = arrList.get(k);
						
						
						break outerloop;
						
					}
					
				}
			}
			
			int[] answer = indexOf(originalArray,items);
			
			Arrays.sort(answer);
			String s = String.format("Case #%d: %d %d",i+1,answer[0]+1,answer[1]+1);
			bw.write(s);
			bw.newLine();
			
			
			
			
			
			
			
			
			
			
			
		}
			
		
		
		br.close();
		bw.close();
		

	}

	private static int[] indexOf(int[] originalArray, int[] items) {
		int[] answer = new int[2];
		for(int a = 0;a<originalArray.length;a++){
			if(originalArray[a] == items[0]){
				answer[0] = a;
			}
		}
		
		for(int a = 0;a<originalArray.length;a++){
			if(originalArray[a] == items[1] && a != answer[0]){
				answer[1] = a;
			}
		}
		return answer;
		
		
	}

	private static void removeCostly(ArrayList<Integer> arrList, int c) {
		for(int i = 0; i< arrList.size();i++){
			if(arrList.get(i) > c){
				arrList.remove(i);
			}
		}
		
	}

	private static ArrayList<Integer> fillArrays(int[] originalArray, String[] split, int I) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0 ; i< I;i++){
			originalArray[i] = Integer.parseInt(split[i]);
			arrList.add(Integer.parseInt(split[i]));
		}
		return arrList;
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		br.close();
		bw.close();
		
	}



}
