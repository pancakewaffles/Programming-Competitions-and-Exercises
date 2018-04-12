package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CookieClickerAlpha {

	public CookieClickerAlpha() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("B-large.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		String result;
		for(int i=0;i<totalcases;i++){
			 String[] strCFX = br.readLine().split("\\s+");
			 double[] CFX=new double[strCFX.length];
			 for(int t=0;t<strCFX.length;t++){
				 CFX[t]=Double.parseDouble(strCFX[t]); // C= CFX[0] F=CFX[1] X=CFX[2]
			 } 

			 double C=CFX[0] ,F=CFX[1] ,X=CFX[2],T=X/2.0;
			 int n=1;
			 while(n>0){
				 
				 double totaltime= notrecursivetotaltime(n,C,F)+X/(2.0+n*F);
				 if(totaltime<T){
					 T=totaltime;
					 
				 }
				 else{
					break;
				 }
				 n++;
			 }
			 result=""+T;
			
			bw.write("Case #"+(i+1)+": "+result);
				bw.newLine();
		}
		bw.close();
		br.close();

	}
	public static double notrecursivetotaltime(int n,double C, double F){
		double nrtt=0;
		int i=0;
		while(i<n){
			i++;
			nrtt+=C/(2.0+((i-1)*F));
			
		}
		return nrtt;
		
	}

}
