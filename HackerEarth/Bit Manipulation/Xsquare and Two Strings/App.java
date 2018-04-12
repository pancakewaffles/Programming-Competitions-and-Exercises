import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				String ans = solver(br.readLine(),br.readLine());
				
				System.out.println(ans);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static String solver(String s1, String s2) {
		char ch;
		for(ch ='a';ch<='z';ch++){ //cool trick to increment alphabets
			if(s1.indexOf(ch) != -1 && s2.indexOf(ch) != -1){
				return "Yes";
			}
		}
		return "No";
	}

}
