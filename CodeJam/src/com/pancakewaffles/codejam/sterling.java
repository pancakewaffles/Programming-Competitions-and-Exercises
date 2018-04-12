package com.pancakewaffles.codejam;

public class sterling {

	public sterling() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int s = S(n,k);

	}

	private static int S(int r, int n) {
		if(n==0){
			return 1;
		}
		else return S(r-1,n-1)+n*S(r-1,n);
	}

}
