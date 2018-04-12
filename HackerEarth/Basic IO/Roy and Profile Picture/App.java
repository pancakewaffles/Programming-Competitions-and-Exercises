import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		int L,N;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			L = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			for(int i =0;i<N;i++){
				System.out.println(checkDimensions(L,br.readLine().split("\\s+")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String checkDimensions(int L,String[] split) {
		int W = Integer.parseInt(split[0]) , H = Integer.parseInt(split[1]);
		if(W<L || H<L){
			return "UPLOAD ANOTHER";
		}else{
			if(W==H){
				return "ACCEPTED";
			}else{
				return "CROP IT";
			}
		}
				
	}

}
