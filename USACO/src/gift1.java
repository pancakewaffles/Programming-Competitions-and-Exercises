/*
ID: tan.chu1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
	
	private static HashMap<String,Integer> generateHash(String[] strarr){
		HashMap<String,Integer> h = new HashMap<String, Integer>();
		for(int i = 0; i<strarr.length;i++){
			h.put(strarr[i],0);
		}
		return h;	
	}
	
	private static void theOperation(String giver, int money, int howmanytogive,String[] whotogive, HashMap<String,Integer> hashgroup){
		if(howmanytogive <= 0){
			return;
		}else if(money==0){
			return;
		}else{
			int remainder = money%howmanytogive;
			if(remainder != 0){
				money = money - remainder;
			}
			//take away giver's money
			hashgroup.put(giver, hashgroup.get(giver)-money);
			int howmucheachget = money / howmanytogive;
			for(int i=0;i<howmanytogive;i++){
				//giving money
				hashgroup.put(whotogive[i],hashgroup.get(whotogive[i])+howmucheachget);
			}


		}
			
		
	}
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int np = Integer.parseInt(f.readLine());
		String[] a = new String[np];
		for(int i = 0; i<np;i++){
			a[i] = f.readLine();
		}
		HashMap<String,Integer> hashgroup = generateHash(a);
		while(true){
			String giver = f.readLine();
			if(giver != null){
				String[] splited = f.readLine().split("\\s+");
				int money = Integer.parseInt(splited[0]);
				int howmanytogive = Integer.parseInt(splited[1]);
				String[] whotogive = new String[howmanytogive];
				for(int i=0;i<howmanytogive;i++){
					whotogive[i] = f.readLine();
				}
				theOperation(giver,money,howmanytogive,whotogive,hashgroup);
				
			}else{
				break;
			}
		}
		for(int i = 0;i<a.length;i++){
			out.println(a[i]+" "+hashgroup.get(a[i]));
		}
		out.close();
		f.close();

	}

}
