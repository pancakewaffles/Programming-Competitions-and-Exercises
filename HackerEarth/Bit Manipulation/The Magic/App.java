import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				int ans = solver(Integer.parseInt(br.readLine()));
				
				System.out.println(ans);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static int solver(int N) {
		int count = 0;
		while(N!=0){
			if((N&1)==0){
				N=N/2;
				
			}else{
				count++;
				N=N-1;
			}
			
		}
		
		
		return count;
	}



}
