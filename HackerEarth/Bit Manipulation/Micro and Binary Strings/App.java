import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			while(T>0){
				int count = 0;
				int N = Integer.parseInt(br.readLine());
				char[] c = br.readLine().toCharArray();
				for(char i : c){
					if(i == '1'){
						count++;
					}
				}
				//int count = rotate(a,N); // Rotate, then check if it is odd
				System.out.println(count);
				T--;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	/* You didn't need all this crap. You just needed to count the number of ones.
	private static int rotate(BigInteger a, int n) {
		BigInteger k = a;
		BigInteger two = new BigInteger("2");
		int count = 0;
		for(int i=0;i<n;i++){
			//System.out.println("Original: "+Integer.toBinaryString(k));
			BigInteger r = (k.and(BigInteger.ONE));
			//System.out.println("Last digit: "+r);
			BigInteger bit_additor = r.shiftLeft(n-1);
			//System.out.println("Bit to be added: "+Integer.toBinaryString(bit_additor));
			k = (k.shiftRight(1)).or(bit_additor);
			//System.out.println("Added bit: "+Integer.toBinaryString(k));
			
			if(k.mod(two).equals(BigInteger.ONE)){
				count++;
			}
		}

		return count;
	}
	*/

}
