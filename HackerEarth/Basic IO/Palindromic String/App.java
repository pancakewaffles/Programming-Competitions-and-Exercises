import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		
		String line="";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			line = br.readLine();
		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}
		
		
		char[] charArray = line.toCharArray();
		int len = charArray.length;
		
		System.out.println(isPalindrome(charArray,len));
		
		
		

	}

	private static String isPalindrome(char[] charArray, int len) {

		int i = 0;
		int j = len-1;
		boolean flag = false;
		if(len%2 ==0){
			//Even number
			while(i!=len/2){
				if(charArray[i] != charArray[j]){
				flag = true;
				}
				i++;
				j--;
			}
			if(flag == false){
				return "YES";
			}else{
				return "NO";
			}
			
		}else{
			//Odd number
			while(i!=j){
				if(charArray[i] != charArray[j]){
				flag = true;
				}
				i++;
				j--;
			}
			if(flag == false){
				return "YES";
			}else{
				return "NO";
			}
		}

		
	}

}
