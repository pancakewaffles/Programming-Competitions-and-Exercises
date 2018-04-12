import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				String ans = solver(br.readLine().split("\\s+"),br.readLine().split("\\s+"));
				
				System.out.println(ans);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static String solver(String[] s1, String[] s2) {
		int Z = Integer.parseInt(s1[0]);
		int N = Integer.parseInt(s1[1]);
		for(String a : s2){
			if((Z=Z&Integer.parseInt(a)) == 0){
				return "Yes";
			}
		}
		return "No";
	}

}
