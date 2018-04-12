package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class ChargingChaos {

	public ChargingChaos() {
		// TODO Auto-generated constructor stub
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
		int result=0;
		for(int i=0;i<totalcases;i++){
			String[] NL = br.readLine().split("//s+");
			int N=Integer.parseInt(NL[0]);
			int L=Integer.parseInt(NL[1]);
			ArrayList<BigInteger> original=new ArrayList<BigInteger>();
			ArrayList<BigInteger> desired=new ArrayList<BigInteger>();
			String[] stroriginal=br.readLine().split("\\s+");
			String[] strdesired=br.readLine().split("\\s+");
			for(int t=0;t<stroriginal.length;t++){
				original.add(new BigInteger(stroriginal[t]));
				desired.add(new BigInteger(strdesired[t]));
				

		}
			int noofzeroes=0;
			int noofones=0;
			for(int s=0;s<original.size();s++){
				char[] charoriginal=(""+original.get(s)).toCharArray();
				if((int)charoriginal[0]==0){
					noofzeroes++;
				}else if((int)charoriginal[0]==1){
					noofones++;
				}
			}
			
		}

	}

}
