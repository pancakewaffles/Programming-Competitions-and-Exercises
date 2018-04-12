package com.pancakewaffles.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AMagicTrick {

	public AMagicTrick() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("A-small-attempt3.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("Output.txt"));
		String line;
		line=br.readLine();
		int totalcases=Integer.parseInt(line);
		String result;
		int counter = 0;
		int chosennumber=0;

		for(int i=0;i<totalcases;i++){
				line=br.readLine();
				int firstchosenrow = Integer.parseInt(line);
				if(firstchosenrow==1){
					//Input original 16 tiles
					int[] row1=new int[4];
					int[] row2=new int[4];
					int[] row3=new int[4];
					int[] row4=new int[4];
					String[] strArray1=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row1[t]=Integer.parseInt(strArray1[t]);
					}
					String[] strArray2=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row2[t]=Integer.parseInt(strArray2[t]);
					}
					String[] strArray3=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row3[t]=Integer.parseInt(strArray3[t]);
					}
					String[] strArray4=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row4[t]=Integer.parseInt(strArray4[t]);
					}
					//end of input process
					int secondchosenrow=Integer.parseInt(br.readLine());
					int a=1;
					while(a<secondchosenrow){
						br.readLine();
						a++;
					}
					String[] strchangedrow1=br.readLine().split("\\s+");
					int[] intchangedrow1=new int[strchangedrow1.length];
					for(int t=0;t<strchangedrow1.length;t++){
						intchangedrow1[t]=Integer.parseInt(strchangedrow1[t]);
					}
					for(int t=0;t<row1.length;t++){
						for(int s=0;s<intchangedrow1.length;s++){
							if(row1[t]==intchangedrow1[s]){
								counter++;
								chosennumber=row1[t];
							}
						}
					}
					if(counter>1){
						result="Bad magician!";
					}
					else if(counter==0){
						result="Volunteer cheated!";
					}
					else{
						result=""+chosennumber;
					}
					bw.write("Case #"+(i+1)+": "+result);
					bw.newLine();
					while(a<4){
						br.readLine();
						a++;
					}

					counter=0;
					chosennumber=0;
				}
				else if(firstchosenrow==2){
					//Input original 16 tiles
					int[] row1=new int[4];
					int[] row2=new int[4];
					int[] row3=new int[4];
					int[] row4=new int[4];
					String[] strArray1=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row1[t]=Integer.parseInt(strArray1[t]);
					}
					String[] strArray2=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row2[t]=Integer.parseInt(strArray2[t]);
					}
					String[] strArray3=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row3[t]=Integer.parseInt(strArray3[t]);
					}
					String[] strArray4=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row4[t]=Integer.parseInt(strArray4[t]);
					}
					//end of input process
					int secondchosenrow=Integer.parseInt(br.readLine());
					int a=1;
					while(a<secondchosenrow){
						br.readLine();
						a++;
					}
					String[] strchangedrow1=br.readLine().split("\\s+");
					int[] intchangedrow1=new int[strchangedrow1.length];
					for(int t=0;t<strchangedrow1.length;t++){
						intchangedrow1[t]=Integer.parseInt(strchangedrow1[t]);
					}
					for(int t=0;t<row1.length;t++){
						for(int s=0;s<intchangedrow1.length;s++){
							if(row2[t]==intchangedrow1[s]){
								counter++;
								chosennumber=row2[t];
							}
						}
					}
					if(counter>1){
						result="Bad magician!";
					}
					else if(counter==0){
						result="Volunteer cheated!";
					}
					else{
						result=""+chosennumber;
					}
					bw.write("Case #"+(i+1)+": "+result);
					bw.newLine();
					while(a<4){
						br.readLine();
						a++;
					}
					counter=0;
					chosennumber=0;
				}
				else if(firstchosenrow==3){
					//Input original 16 tiles
					int[] row1=new int[4];
					int[] row2=new int[4];
					int[] row3=new int[4];
					int[] row4=new int[4];
					String[] strArray1=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row1[t]=Integer.parseInt(strArray1[t]);
					}
					String[] strArray2=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row2[t]=Integer.parseInt(strArray2[t]);
					}
					String[] strArray3=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row3[t]=Integer.parseInt(strArray3[t]);
					}
					String[] strArray4=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row4[t]=Integer.parseInt(strArray4[t]);
					}
					//end of input process
					int secondchosenrow=Integer.parseInt(br.readLine());
					int a=1;
					while(a<secondchosenrow){
						br.readLine();
						a++;
					}
					String[] strchangedrow1=br.readLine().split("\\s+");
					int[] intchangedrow1=new int[strchangedrow1.length];
					for(int t=0;t<strchangedrow1.length;t++){
						intchangedrow1[t]=Integer.parseInt(strchangedrow1[t]);
					}
					for(int t=0;t<row1.length;t++){
						for(int s=0;s<intchangedrow1.length;s++){
							if(row3[t]==intchangedrow1[s]){
								counter++;
								chosennumber=row3[t];
							}
						}
					}
					if(counter>1){
						result="Bad magician!";
					}
					else if(counter==0){
						result="Volunteer cheated!";
					}
					else{
						result=""+chosennumber;
					}
					bw.write("Case #"+(i+1)+": "+result);
					bw.newLine();
					while(a<4){
						br.readLine();
						a++;
					}
					counter=0;
					chosennumber=0;
				}
				else if(firstchosenrow==4){
					//Input original 16 tiles
					int[] row1=new int[4];
					int[] row2=new int[4];
					int[] row3=new int[4];
					int[] row4=new int[4];
					String[] strArray1=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row1[t]=Integer.parseInt(strArray1[t]);
					}
					String[] strArray2=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row2[t]=Integer.parseInt(strArray2[t]);
					}
					String[] strArray3=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row3[t]=Integer.parseInt(strArray3[t]);
					}
					String[] strArray4=br.readLine().split("\\s+");
					for(int t=0;t<4;t++){
						row4[t]=Integer.parseInt(strArray4[t]);
					}
					//end of input process
					int secondchosenrow=Integer.parseInt(br.readLine());
					int a=1;
					while(a<secondchosenrow){
						br.readLine();
						a++;
					}
					String[] strchangedrow1=br.readLine().split("\\s+");
					int[] intchangedrow1=new int[strchangedrow1.length];
					for(int t=0;t<strchangedrow1.length;t++){
						intchangedrow1[t]=Integer.parseInt(strchangedrow1[t]);
					}
					for(int t=0;t<row1.length;t++){
						for(int s=0;s<intchangedrow1.length;s++){
							if(row4[t]==intchangedrow1[s]){
								counter++;
								chosennumber=row4[t];
							}
						}
					}
					if(counter>1){
						result="Bad magician!";
					}
					else if(counter==0){
						result="Volunteer cheated!";
					}
					else{
						result=""+chosennumber;
					}
				
					bw.write("Case #"+(i+1)+": "+result);
					bw.newLine();
					while(a<4){
						br.readLine();
						a++;
					}
					counter=0;
					chosennumber=0;
				}
				else{
					result="Volunteer cheated!";
				}
		}
		bw.close();
		br.close();

	}

}
