import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		String line = "";
		int N = 0;
		BigInteger answer = BigInteger.valueOf(1);
		BigInteger modulum = BigInteger.valueOf(1000000007);
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			line = br.readLine();
			N = Integer.parseInt(line);
			line = br.readLine();
			String[] stringList = line.split("\\s+");
			for(String a : stringList){
				answer = (answer.multiply(new BigInteger(a))).mod(modulum);
			}
			System.out.println(answer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read file");
		}

		
		

	}

}
