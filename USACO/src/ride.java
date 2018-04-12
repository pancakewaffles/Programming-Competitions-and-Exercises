/*
ID: tan.chu1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ride {
	
	private static int convert(String s){
		char cArray[] = s.toCharArray();
		int number=1;
		for(int i=0;i<cArray.length;i++){
			number*=Character.toUpperCase(cArray[i]) - 'A' + 1;
		}
		return number;
		
		
	}
	
	private static String outputter(int a,int b){
		if (a%47 == b%47){
			return "GO";
		}else{
			return "STAY";
		}
	}

	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String s1= f.readLine();
		String s2 = f.readLine();
		int a = convert(s1);
		int b = convert(s2);
		System.out.println(outputter(a,b));
		out.println(outputter(a,b));
		out.close();
		System.exit(0);
		

	}

}
