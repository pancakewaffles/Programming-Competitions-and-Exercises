/*
ID: tan.chu1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

public class friday {
	
	private static boolean checkifleapyear(int year){
		if(year%100 != 0){
			if(year%4 == 0){
				return true;
			}else{
				return false;
			}
		}else{
			if(year%400 == 0){
				return true;
			}else{
				return false;
			}
		}
	}

	/*
	 * How the frequency hash works?
	 * 0->Sunday
	 * 1->Monday
	 * 2->Tuesday
	 * 3->Wednesday
	 * 4->Thursday
	 * 5->Friday
	 * 6->Saturday
	 */
	

	private static HashMap<Integer,Integer> generateHash(){
		HashMap<Integer,Integer> frequencyhash = new HashMap<Integer,Integer>();
		frequencyhash.put(0, 0);
		frequencyhash.put(1, 0);
		frequencyhash.put(2, 0);
		frequencyhash.put(3, 0);
		frequencyhash.put(4, 0);
		frequencyhash.put(5, 0);
		frequencyhash.put(6, 0);
		return frequencyhash;
		
		
	}
	
	private static int calculatenextfirstofmonth(int firstofcurrentmonth,int month_counter,boolean leapyear){
		if(month_counter ==4 || month_counter ==6||month_counter ==9||month_counter==11){
			return (firstofcurrentmonth+30)%7;
		}else if(month_counter ==2){
			if(leapyear){
				return (firstofcurrentmonth+29)%7;
			}else{
				return (firstofcurrentmonth+28)%7;
			}
		}else{
			return (firstofcurrentmonth+31)%7;
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		HashMap<Integer,Integer> frequencyhash = generateHash();
		
		int N = Integer.parseInt(f.readLine());
		int year = 1900;
		int firstofyear = 1; //Jan 1 1900 is a monday
		for(int i =0;i<N;i++){
			int firstofmonth = firstofyear;
			boolean leapyear = checkifleapyear(year+i);
			int month_counter = 1; //month counter, will be useful later on, 1 = Jan, 12 = Dec
			while(month_counter <= 12){
				
				int thethirteenthday = (firstofmonth+5)%7; //this is the most confusing part
				
				frequencyhash.put(thethirteenthday, frequencyhash.get(thethirteenthday)+1);
				
				firstofmonth = calculatenextfirstofmonth(firstofmonth,month_counter,leapyear);
				
				if(month_counter==12){
					firstofyear = firstofmonth;
				}
				month_counter++;
			}
			
		}
		out.println(frequencyhash.get(6)+" "+frequencyhash.get(0)+" "+frequencyhash.get(1)+" "+frequencyhash.get(2)+" "+frequencyhash.get(3)+" "+frequencyhash.get(4)+" "+frequencyhash.get(5));
		f.close();
		out.close();


	}

}
