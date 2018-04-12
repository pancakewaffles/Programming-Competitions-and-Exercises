import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			while(T>0){
				String[] s = br.readLine().split("\\s+");
				String a = s[0];
				int N = Integer.parseInt(s[1]);
				int M = Integer.parseInt(s[2]);
				
				char[] c = a.toCharArray();
				
				Arrays.sort(c,N,M+1); //Because Arrays.sort somehow exclude the toIndex, so we have to put toIndex+1;
				
				for(int i = N, j = M;i<j;i++,j--){
					char temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
				
				
				System.out.println(new String(c));
				T--;
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
