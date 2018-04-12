package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

	public Main2() {
		
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B-large-practice.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		String result;
		for(int i=0;i<totalcases;i++){
		 String[] patient = br.readLine().split("\\s+");
		 String[] operator = new String[patient.length];
		 for(int t=0;t<patient.length;t++){
			 operator[t]=patient[patient.length-1-t];
		 }
		 result=operator[0];
		 for(int a=1;a<patient.length;a++){
			 result+=" "+operator[a];
		 }
			bw.write("Case #"+(i+1)+": "+result);
			bw.newLine();
		    
		 
		}
		bw.close();
		br.close();

	}

}
