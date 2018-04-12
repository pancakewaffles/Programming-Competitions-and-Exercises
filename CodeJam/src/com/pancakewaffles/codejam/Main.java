/**
 * 
 */
package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Chavez Tan
 *
 */
public class Main {


	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("A-large-practice.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		
		for(int i=0;i<totalcases;i++){
			line=br.readLine();
			int credits=Integer.parseInt(line);
			line=br.readLine();
			int noofitems=Integer.parseInt(line);
			String[] stringprices=new String[noofitems];
			int[] prices = new int[noofitems];
			stringprices=br.readLine().split("\\s+");
			for(int t=0;t<noofitems;t++){
				prices[t]=Integer.parseInt(stringprices[t]);
			}
			for(int a=0;a<noofitems;a++){
			for(int b=a+1;b<noofitems;b++){
				if(prices[a]+prices[b]==credits){
					
					
					bw.write("Case #"+(i+1)+": "+(a+1)+" "+(b+1));
					bw.newLine();
					
				
					break;
				}
				
				
			}
			
			}
			
		}
		br.close();
		bw.close();
	}

}
