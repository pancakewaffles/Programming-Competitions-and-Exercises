import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class App {
	
	private static String fileName = "B-large-practice.in";
	private static File inputFile = new File(fileName);
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static List<String> stringList;
	
	private static int count = 0;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new FileReader(inputFile));
		int total = Integer.parseInt(br.readLine());
		
		File outputFile = new File("outputBLarge.out");
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		if(total != -1){
			for(int i = 0;i<total;i++){
				
				
				String[] S = br.readLine().split("");
				
				stringList = new LinkedList<String>();
				
				for(String s : S){
					stringList.add(s);
				}
				//Stage 1: If last entry is +, remove it.
				while(stringList.get(stringList.size()-1).equals("+")){
					stringList.remove(stringList.size()-1);
					if(stringList.size()== 0){
						break;
					}
					
				}
				
				//Stage 1a: Check if it is all ++++++, if so, then just output count = 0
				
				if(stringList.size() == 0){
					bw.write(String.format("Case #%d: %d",i+1,count));
					bw.newLine();
					continue;
				}
				
				
				//Stage 2: Go from left to right, flip if there is a difference.
				for(int j = 0; j<stringList.size()-1;j++){
					if(stringList.get(j).equals(stringList.get(j+1))){
						
						
					}else{
						flip(j);
						count++;
					}
	
				}
				//Stage 3: Check end result
				/*
				int check = 0;
				for(String s:stringList){
					if(s.equals("-")){
						check++;
					}
				}
				if(check == stringList.size()){
					System.out.println("Hurrah!");
				}
				*/
				count += 1;
				
				bw.write(String.format("Case #%d: %d",i+1,count));
				bw.newLine();
				
				count = 0;
				
				
				
				
				
			}
			
		}else{
			System.out.println("Total is null!");
		}
		
		
		br.close();
		bw.close();
		
		

	}



	private static void flip(int index) {

		for(int k=0;k<=index;k++){
			if(stringList.get(k).equals("+")){
				stringList.set(k, "-");
			}else if(stringList.get(k).equals("-")){
				stringList.set(k, "+");
			}
		}
		
		
		
	}





}
