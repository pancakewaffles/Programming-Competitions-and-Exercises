import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		
		String fileName = "A-large-practice.in";
		File inputFile = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		int total = Integer.parseInt(br.readLine());
		
		File file = new File("outputALarge.out");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		if(total != -1){
			for(int i = 0;i<total;i++){
				int N = Integer.parseInt(br.readLine());
				
				if(N==0){
					bw.write(String.format("Case #%d: %s",i+1,"INSOMNIA"));
					bw.newLine();
				}else{
				bw.write(String.format("Case #%d: %d",i+1,processor(N)));
				bw.newLine();
				}
				
			}
			
		}else{
			System.out.println("Total is null!");
		}
		
		
			br.close();
			bw.close();

		
		
		
		

	}

	private static int processor(int N) {
		
		List<Integer> list = new ArrayList<Integer>();
		int tempN = 0;
		
		for(int i = 1; i<11111;i++){
			if(list.size() == 10){
				System.out.println("Broke in Check 1");
				break;
			}
			
			tempN = i*N;
			
			List<Integer> digits = breakDown(tempN);
			
			
			for(int digit : digits){

				if(list.contains(digit) == true){
					
				}else{
					list.add(digit);
				}
			}
			
			if(list.size()==10){
				break;
			}
		
			
		}
		
		return tempN;
	}

	private static List<Integer> breakDown(int n) {
		List<Integer> list = new ArrayList<Integer>();
		while(n>0){
		int lastDigit = n % 10;
		list.add(lastDigit);
		n = n/10;
		}
		return list;
		
	}

}
