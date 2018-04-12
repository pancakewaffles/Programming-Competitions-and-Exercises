import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] s = br.readLine().split("\\s+");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int[][] arr = new int[N][M];
			int[][] transposed = new int[M][N];
			
			//Reading 
			for(int i = 0;i<N;i++){
				s = br.readLine().split("\\s+");
				for(int j = 0;j<M;j++){
				arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			//Actually transposing
			for(int i =0;i<M;i++){
				for(int j = 0;j<N;j++){
					transposed[i][j] = arr[j][i];
					System.out.print(arr[j][i] + " ");
				}
				System.out.println();
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
