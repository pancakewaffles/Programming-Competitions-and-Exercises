package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DeceitfulWar {

	public DeceitfulWar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("D-large.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		for(int i=0;i<totalcases;i++){
			int NaomiScoreWar=0,NaomiScoreDeceitfulWar=0;
			int noofblocksperperson=Integer.parseInt(br.readLine());
			ArrayList<Double> Naomiblocks=new ArrayList<Double>();
			String[] strNaomiblocks=br.readLine().split("\\s+");
			for(int a=0;a<strNaomiblocks.length;a++){
				Naomiblocks.add(Double.parseDouble(strNaomiblocks[a]));
				
			}
			ArrayList<Double> Kenblocks=new ArrayList<Double>();
			String[] strKenblocks=br.readLine().split("\\s+");
			for(int a=0;a<strKenblocks.length;a++){
				Kenblocks.add(Double.parseDouble(strKenblocks[a]));
			}
			 Collections.sort(Naomiblocks);
			 Collections.sort(Kenblocks);
			ArrayList<Double> Naomiblocks2=(ArrayList<Double>) Naomiblocks.clone();
			ArrayList<Double> Kenblocks2=(ArrayList<Double>) Kenblocks.clone();
			
			//Calculate Score for War
			 int t=0;
			while(t<Naomiblocks.size()){
				for(int k=0;k<Kenblocks.size();k++){
					if(Kenblocks.get(k)>Naomiblocks.get(t)){
						Kenblocks.remove(k);
						Naomiblocks.remove(t);
						break;
					}else if(k+1 == Kenblocks.size()){
						Kenblocks.remove(0);
						Naomiblocks.remove(t);
						NaomiScoreWar++;
						
					}
				}
				
			}
			//Calculate Score for DeceitfulWar
			int s=0;
			while(s<Naomiblocks2.size()){
				if(Naomiblocks2.get(s)<Kenblocks2.get(0)){
					Naomiblocks2.remove(s);
					Kenblocks2.remove(Kenblocks2.size()-1);
					
				}else{
					Naomiblocks2.remove(s);
					Kenblocks2.remove(0);
					NaomiScoreDeceitfulWar++;
				}
			}
			
			bw.write("Case #"+(i+1)+": "+NaomiScoreDeceitfulWar+" "+NaomiScoreWar);
			bw.newLine();
		}
		bw.close();
		br.close();
	}

}
