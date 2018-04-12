import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			
			while(T!=0){
				int N = Integer.parseInt(br.readLine());
				String[] intArr = br.readLine().split("\\s+");
				int ans = 0;
				if(N == 1){
					ans = Integer.parseInt(intArr[0]);
				}
				System.out.println(ans);
				T--;
			}
				
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
