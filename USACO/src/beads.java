/*
ID: tan.chu1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {
	

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int N = Integer.parseInt(f.readLine());
		String str = f.readLine();
		
		//Loop through the beads
		//i moves backwards, j moves forwards
		int MaxCounter = 0;
		for(int i =0;i<N;i++){
			int j = i+1;
			if(j==N){
				j=0;
			}
			//movement of i
			int i_backup = i;
			int prev = i-1;
			int counter = 1;
			while(true){
				if(prev<0){
					prev=N-1;
				}
				if(prev == j){
					counter += 1;
					break;
				}
				if(str.charAt(i) == str.charAt(prev)){
					counter += 1;
					prev = prev - 1;
					
				}else if(str.charAt(prev)=='w'){
					counter += 1;
					prev = prev - 1;
					
				}else if(str.charAt(i)=='w'){
					counter += 1;
					i = prev;
					prev = prev - 1;
					
				}else{
					
					break;
				}

			}
			i = i_backup;
			if(prev == j){
				if(counter>MaxCounter){
					MaxCounter = counter;
				}
				continue;
			}
			//movement of j
			int j_backup = j;
			int next = j + 1;
			counter += 1;
			while(true){
				if(next >= N){
					next = 0;
				}
				if(next == prev){
					counter += 1;
					break;
				}
				if(str.charAt(j) == str.charAt(next)){
					counter += 1;
					next = next + 1;
				}else if(str.charAt(next)=='w'){
					counter += 1;
					next = next + 1;
				}else if(str.charAt(j)=='w'){
					counter += 1;
					j = next;
					next = next + 1;
				}else{
					break;
				}
				
			}
			j = j_backup;
			if(counter>MaxCounter){
				MaxCounter = counter;
			}
			
		
				
			
		}
		out.println(MaxCounter);
		
		
		f.close();
		out.close();

	}

}
