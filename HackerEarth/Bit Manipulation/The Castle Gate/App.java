import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				System.out.println(solver(Integer.parseInt(br.readLine())));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static int solver(int parseInt) {
		int count = 0;
		int N = parseInt;
		for(int i =1;i<N;i++){
			for(int j =i+1;j<=N;j++){
				if((i^j) <= N){
					count++;
				}
			}
		}
		return count;
	}

}
