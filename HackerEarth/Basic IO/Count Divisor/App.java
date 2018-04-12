import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		String[] list = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			list = br.readLine().split("\\s+");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int l = Integer.parseInt(list[0]);
		int r = Integer.parseInt(list[1]);
		int k = Integer.parseInt(list[2]);
		
		int count = 0;
		
		while(l<=r){
			if(l%k==0){
				count++;
			}
			l++;
		}
		System.out.println(count);
	}

}
