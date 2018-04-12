package com.pancakewaffles.codejam;

public class CoolProblem {

	public CoolProblem() {
		// TODO Auto-generated constructor stub
	}

	static int x=0;
	public static void main(String[] args) {
		int[] primes={2,3,5,7,11,13,17,19};
		int b=primefinder(1,primes);
		//System.out.println(x+" "+b);

	}
	public static int primefinder(int a,int[] primes){
		int lowestprime=2;
		
		while(a!=3135){
		for(int i = 0;i<primes.length;i++){
			if(a%primes[i] != 0){
				 lowestprime=primes[i];
				break;
			}
		}
		int primeproduct=1;
		for(int i=0;i<primes.length;i++){
			if(primes[i]<lowestprime){
				primeproduct=primeproduct*primes[i];
			}
		}
		a=a*lowestprime/primeproduct;
		x+=1;
		System.out.println(x+" "+a);
		}
		return a;
		
		
		
	}

}
