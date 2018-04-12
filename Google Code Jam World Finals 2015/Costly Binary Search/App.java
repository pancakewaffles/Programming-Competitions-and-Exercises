import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// Conclusion: The indexOfSymmetry method does not work
public class App {
	private static String fileName = "Costly Binary Search/A-small-practice.in";
	private static File inputFile = new File(fileName);
	private static File outputFile = new File(fileName + ".out");
	private static BufferedReader br,br2;
	private static BufferedWriter bw;
	
	private static int totalWeight = 0;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		
		int T = Integer.parseInt(br.readLine());
		int i = 1;
		
		while(T>0){
			
			String weights = br.readLine();
			
			findMax(weights);

			bw.write(String.format("Case #%d: %d", i,totalWeight));
			bw.newLine();
			i++;
			T--;
			totalWeight = 0;
			
		}
		
		br.close();
		bw.close();
		
		//* Debug
		totalWeight = 0;
		findMax("191");
		System.out.println(totalWeight);
		//*/
		
		

	}

	private static void findMax(String weights) {
		if(weights.length() == 1){
			totalWeight += (weights.charAt(0)- '0'); 
			return;
		}
		int indexOfSymmetry = SymmetricIndexFinder(weights);
		totalWeight += (weights.charAt(indexOfSymmetry) -'0');
		
		
		int leftWeights = calculateLeftWeights(indexOfSymmetry,weights);
		int rightWeights = calculateRightWeights(indexOfSymmetry,weights);
		
		if(leftWeights > rightWeights){
			String weight_trimmed = weights.substring(0,indexOfSymmetry);
			findMax(weight_trimmed);
		}else if(rightWeights > leftWeights){
			String weight_trimmed = weights.substring(indexOfSymmetry+1,weights.length());
			findMax(weight_trimmed);
		}else{
			int prev = totalWeight;
			findMax(weights.substring(0,indexOfSymmetry));
			int temp = totalWeight;
			totalWeight = prev;
			findMax(weights.substring(indexOfSymmetry+1,weights.length()));
			totalWeight = Math.max(temp, totalWeight);
		}
		
		
	}

	private static int calculateRightWeights(int indexOfSymmetry, String weights) {
		int weight = 0;
		for(int i = indexOfSymmetry +1;i<weights.length();i++){
			weight += (weights.charAt(i) -'0');
		}
		return weight;
	}

	private static int calculateLeftWeights(int indexOfSymmetry, String weights) {
		int weight = 0;
		for(int i = indexOfSymmetry -1;i>=0;i--){
			weight += (weights.charAt(i) -'0');
		}
		return weight;
	}

	private static int SymmetricIndexFinder(String weights) {
		int index = -1;
		int max = Integer.MAX_VALUE;
		for(int i =0;i<weights.length();i++){
			int leftWeights = 0 ,rightWeights = 0;
			
			// Calculate Left Weights
			for(int j = i-1;j>=0;j--){
				leftWeights += (weights.charAt(j) -'0');
			}
			
			// Calculate Right Weights
			for(int k = i+1;k<weights.length();k++){
				rightWeights += (weights.charAt(k) -'0');
			}
			
			int r = Math.abs(leftWeights - rightWeights);
			
			if(r < max){
				max = r;
				index = i;
			}
		}
		/* Refinement which kinda failed
		int differenceLeft, differenceRight;
		if(index - 1 > 0 && (weights.charAt(index) - '0') - (weights.charAt(index-1) -'0') > 0 ){
			differenceLeft = (weights.charAt(index) - '0') - (weights.charAt(index-1) -'0');
		}else{
			differenceLeft = -1;
		}
		if(index + 1 < weights.length() && (weights.charAt(index) - '0') - (weights.charAt(index+1) -'0') > 0 ){
			differenceRight =(weights.charAt(index) - '0') - (weights.charAt(index+1) -'0');
		}else{
			differenceRight = -1;
		}
		if(differenceLeft > differenceRight){
			index = index - 1;
		}else if(differenceRight > differenceLeft){
			index = index + 1;
		}else if(differenceLeft > 0 && differenceLeft == differenceRight){
			index = index - 1;
		}
		*/
		
		return index;
	}
	
	

}
