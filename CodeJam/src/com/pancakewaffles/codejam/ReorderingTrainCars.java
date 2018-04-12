package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReorderingTrainCars {

	public ReorderingTrainCars() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C-small-practice.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		for(int i=0;i<totalcases;i++){
			String[] NMK=br.readLine().split("\\s+");
			int N= Integer.parseInt(NMK[0]);
			int M= Integer.parseInt(NMK[1]);
			int K= Integer.parseInt(NMK[2]);
			int result=K;
			if(M>=3 && N>=3){
				if(K>=5){
					int a=1,b=1;
					while(a*b+2*a+2*b<K){
						if(a>b){
							b++;
						}else{
							a++;
						}
						result=2*a+2*b;
						
						
					}
					if(a*b+2*a+2*b>K){
						int points=a*b+2*a+2*b;
						while(points>K){
							points=points-2;
							result=result-1;
						}
					}
					
				}
			}
			
			
			bw.write("Case #"+(i+1)+": "+result);
			bw.newLine();
		}
		bw.close();
		br.close();

	}

}
