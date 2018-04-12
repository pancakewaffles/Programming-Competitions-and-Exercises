import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * The whole idea of this pancake flipping problem, lies in realising that the left-most pancake p1 is only affected by the left-most flip f1.
 * That means the initial status of p1 completely determines what we need to do with f1.
 * If p1 is blank, then we have to act f1. Else, we leave it.
 * Then we realise that there is only one flip f2 that affects the next pancake p2 (to the right of p1).
 * If p2 is blank, then we have to act f2. I don't care what happens to p3, I will deal with it next.
 * 
 * This means that we can iterate pancakes from p1 all the way to p(N-K+1) because that is the last pancake we can flip without violating the rules.
 * Afterwards, we simply check through the entire row of pancakes to see if we get +++++. If we do, great! If not, we print IMPOSSIBLE.
 * 
 * E.g. N = 10 , K = 5 (We can only flip 5 pancakes at any one time. No more, no less.
 * 
 * 
 */

public class App {
	
	private static String fileName = "A_OversizedPancakeFlipper/A-large-practice.in";
	private static File inputFile = new File(fileName);
	private static BufferedReader br;
	private static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(inputFile)); 
		int T = Integer.parseInt(br.readLine());
		File outputFile = new File("A_OversizedPancakeFlipper/Alarge.out");
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		int caseNo = 1;
		while(caseNo<=T){
			String[] ss = br.readLine().split("\\s+");
			
			char[] pancakes = ss[0].toCharArray();
			int flipperSize = Integer.parseInt(ss[1]);
			int count = 0;
			for(int i = 0;i<pancakes.length-flipperSize+1;i++) {
				if(pancakes[i] == '-') {
					count++;
					for(int j = i;j<i+flipperSize;j++) {
						if(pancakes[j] == '-') {
							pancakes[j] = '+';
						}else {
							pancakes[j] = '-';
						}
					}
					
					
				}
			}
			
			boolean sentinel = true;
			for(int i = 0;i<pancakes.length;i++) {
				if(pancakes[i] == '-') {
					sentinel = false;
				}
			}
			if(sentinel == true) {
				bw.write(String.format("Case #%d: %d",caseNo,count));
			}else if(sentinel == false) {
				bw.write(String.format("Case #%d: %s",caseNo,"IMPOSSIBLE"));
			}
			
			
			bw.newLine();
			
			
			caseNo++;
		}
		
		
		br.close();
		bw.close();
		
		
	}

}
