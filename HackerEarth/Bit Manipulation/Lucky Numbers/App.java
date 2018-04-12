import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				long ans = solver(Long.parseLong(br.readLine()));
				
				System.out.println(ans);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static long solver(long N) {
		long sum =0;
		long a = 1;
		long b = 1;
		for(int i = 0;i<64;i++){
			for(int j = i+1;j<63;j++){
				
				long x = (a<<i) | (b<<j); //Bit Addition
				
				if(x <= N){
					sum = (sum+x)%1000000007L;
					continue;
				}
				break;
			}
		}
		return sum;
	}

}
