import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			 line = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder("");
		char[] charArr = line.toCharArray();
		for(char a : charArr){
			if(Character.isUpperCase(a)==true){
				char b = Character.toLowerCase(a);
				sb.append(b);
				
			}else{
				char b = Character.toUpperCase(a);
				sb.append(b);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
