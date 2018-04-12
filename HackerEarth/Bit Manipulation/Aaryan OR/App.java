import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(br.readLine());
			String[] intArr = br.readLine().split("\\s+");
			int ans = 0;
			for(String a : intArr){
				ans = (ans | Integer.parseInt(a));
			}
				
			System.out.println(ans);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
