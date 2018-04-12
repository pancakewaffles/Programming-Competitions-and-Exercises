import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
	private static String fileName = "T9 Spelling/C-large-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static Map<String, String> map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		
		//Setting up the map
		map = new HashMap<String,String>();
		map.put("a", "2");
		map.put("b", "22");
		map.put("c", "222");
		map.put("d", "3");
		map.put("e", "33");
		map.put("f", "333");
		map.put("g", "4");
		map.put("h", "44");
		map.put("i", "444");
		map.put("j", "5");
		map.put("k", "55");
		map.put("l", "555");
		map.put("m", "6");
		map.put("n", "66");
		map.put("o", "666");
		map.put("p", "7");
		map.put("q", "77");
		map.put("r", "777");
		map.put("s", "7777");
		map.put("t", "8");
		map.put("u", "88");
		map.put("v", "888");
		map.put("w", "9");
		map.put("x", "99");
		map.put("y", "999");
		map.put("z", "9999");
		
		
		while( N > 0){
			
			String[] split = br.readLine().split("");
		
			
			StringBuilder s = new StringBuilder();
			char prev = '.';
			for(int j =0;j<split.length;j++){
				if(split[j].equals(" ")){
					if(split[j].indexOf(prev) != -1){
						s.append(" ");
					}
					s.append("0");
					prev = ' ';
				}else{
					
					if(map.get(split[j]).indexOf(prev) != -1){
						// The previous letter uses the same number
						s.append(" ");
						s.append(map.get(split[j]));
						prev = map.get(split[j]).charAt(0);
					}else{
						s.append(map.get(split[j]));
						prev = map.get(split[j]).charAt(0);
					}
				}
			}
			String result = s.toString();
			
			
			
			bw.write(String.format("Case #%d: %s", i, result));
			bw.newLine();
			i++;
			N--;
		}
		
		
		
		
		
		
		br.close();
		bw.close();
	}

}


