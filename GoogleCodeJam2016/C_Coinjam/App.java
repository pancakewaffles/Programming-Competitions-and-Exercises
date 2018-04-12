import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;

public class App {
	
	private static String fileName = "C-large-practice.in";
	private static File inputFile = new File(fileName);
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static LinkedList<Integer> intList;

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		br = new BufferedReader(new FileReader(inputFile));
		int total = Integer.parseInt(br.readLine()); // Will equal 1.
		
		
		File outputFile = new File("outputC.out");
		bw = new BufferedWriter(new FileWriter(outputFile));
		bw.write("Case #1:");
		bw.newLine();
		
		// Since we only have 1 test case, we can do away with the first for loop
		String[] a = br.readLine().split(" ");
		int N = Integer.parseInt(a[0]);
		int J = Integer.parseInt(a[1]);
		
		// Modify these variables for easier usage
		//N=16;
		//J=50;
		
		intList = new LinkedList<Integer>();
		
		populateList(N);
		
		String jamcoin = joinUp(intList);
		


		for(int i =0;i<J;i++){
			
			while(process(jamcoin) == false){ // means it is prime
				jamcoin = Long.toString((Long.valueOf(jamcoin,2)+Long.valueOf("10",2)),2);
					
			}
			
			System.out.println("Case #"+(i+1)+" New jamcoin: "+jamcoin);
			
		
			
			bw.write(String.format("%s %d %d %d %d %d %d %d %d %d",jamcoin,
					whynotPrime(Long.valueOf(jamcoin,2)),
					whynotPrime(Long.valueOf(jamcoin,3)),
					whynotPrime(Long.valueOf(jamcoin,4)),
					whynotPrime(Long.valueOf(jamcoin,5)),
					whynotPrime(Long.valueOf(jamcoin,6)),
					whynotPrime(Long.valueOf(jamcoin,7)),
					whynotPrime(Long.valueOf(jamcoin,8)),
					whynotPrime(Long.valueOf(jamcoin,9)),
					whynotPrime(Long.valueOf(jamcoin,10))));
			
			bw.newLine();
			
			jamcoin = Long.toString((Long.valueOf(jamcoin,2)+Long.valueOf("10",2)),2);
			
			
		}
		
		
		
		
		br.close();
		bw.close();
	}
	
	private static boolean process(String jamcoin) {
		
		if(isPrime(Long.valueOf(jamcoin,2))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,3))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,4))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,5))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,6))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,7))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,8))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,9))){
			return false;
		}else if(isPrime(Long.valueOf(jamcoin,10))){
			return false;
		}else{
			return true;
		}
	}

	private static String joinUp(LinkedList<Integer> list) {
		String s = "";
		for(int i=0;i<list.size();i++){
			s = s + list.get(i).toString();
		}
		return s;
		
	}

	private static void populateList(int N) {
		for(int i =0;i<N;i++){
			intList.add(0);
		}
		intList.set(0, 1);
		intList.set(intList.size()-1, 1);
		
	}

	private static boolean isPrime(Long long1){
		if(long1%2 == 0){
			return false;
		}
		for(long i=3;i*i<long1;i+=2){
			if(long1%i==0){
				return false;
			}
		}
		return true;
	}
	
	private static long whynotPrime(long n){
		if(n%2 == 0){
			return 2;
		}
		for(long i=3;i*i<n;i+=2){
			if(n%i==0){
				return i;
			}
		}
		return 0;
	}

}
