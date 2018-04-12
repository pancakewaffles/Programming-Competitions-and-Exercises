import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {


	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String line;
			while((line = br.readLine()) != null){
				
				if(line.contains("//")){
					 int a = line.indexOf("//");
					 String sub = line.substring(0, a); // Excludes the letter at index a
					 String s = sub.replaceAll("->", ".");
					 System.out.println(s+ line.substring(a) );
				}else{
					String s =line.replaceAll("->", ".");
					System.out.println(s);
				}
				
				
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
