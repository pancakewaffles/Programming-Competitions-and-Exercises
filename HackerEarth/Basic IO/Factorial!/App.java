import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		int N;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			N = Integer.parseInt(br.readLine());
			System.out.println(factorial(N));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static int factorial(int n) {
		if(n==1){
			return 1;
		}
		return n*factorial(n-1);
	}

}
