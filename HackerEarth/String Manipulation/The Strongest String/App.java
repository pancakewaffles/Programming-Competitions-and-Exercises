import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			// Just straight up find from 'z' to 'a'
			// The solution is [
			int j =0;
			String result = "";
			for(char i = 'z';i>='a';i--){
				int index = str.indexOf(i, j); //includes letter at j. 
				//But in case you think that the letter at index j might be added again, no worries. We are looking for a different letter because we moved on in the loop.
				if(index >= 0){
					j = index;
					result = result + str.charAt(index);
				}
			}
			System.out.println(result);
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
