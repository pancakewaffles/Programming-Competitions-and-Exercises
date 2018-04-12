import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int T;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			T = Integer.parseInt(br.readLine());
			for(int i =0;i<T;i++){
				solver(Integer.parseInt(br.readLine()),br.readLine().split("\\s+"));
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void solver(int N, String[] string) {
		int[] arr = new int[string.length];
		for(int i=0;i<string.length;i++){
			arr[i] = Integer.parseInt(string[i]);
		}
		Arrays.sort(arr);
		for(int i = string.length-1;i>=0;i--){
			System.out.print(arr[i]+" ");
		}
		
	}

}
