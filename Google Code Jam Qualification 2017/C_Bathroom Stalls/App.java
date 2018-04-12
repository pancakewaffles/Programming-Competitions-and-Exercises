import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * Well, the dumb way is to just follow the instructions and code the rules. The small dataset 1 is small enough such that it works.
 * For each stall, calculate Ls and Rs. 
 * Then consider the SET of stalls with the farthest closest neighbour - those stalls which min(Ls,Rs) is largest.
 * Basically, for 6 stalls and 2 guys.
 * . . . . . .
 * 1 2 3 4 5 6
 * 
 * For stall 3, Ls = 2, Rs = 3. min(Ls,Rs) = 2 , max(Ls,Rs) = 3.
 * For stall 4, Ls = 3, Rs = 2. min(Ls,Rs) = 2 , max(Ls,Rs) = 3.
 * 
 * Choose the leftmost stall, Stall 3.
 * 
 * Second guy comes in, 
 * . . 0 . . .
 * 1 2 3 4 5 6
 * Stall 1: Ls = 0, Rs = 1, min() = 0 , max() = 1.
 * Stall 2: Ls = 1, Rs = 0, min() = 0, max() = 1.
 * Stall 4: Ls = 0, Rs = 2, min() = 0, max() = 2. *
 * Stall 5: Ls = 1, Rs = 1, min() = 1, max() = 1. *
 * 
 * Choosing the maximum of min() and the minimum of max() implies that you want to center-most stall, with as much space to your left as to your right.
 * Choosing the maximum of min() -> I want to have as much space as possible.
 * Choosing the maximum of max() -> This follows from choosing the maximum of min(). Out of all the stalls that have as much space as possible, I want the one that is the most evenly spaced.
 * 
 * 
 */
public class App {
	
	private static String fileName = "C_Bathroom Stalls/C-small-practice-2.in";
	private static File inputFile = new File(fileName);
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static Set<Stall> stallSet;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader(inputFile)); 
		int T = Integer.parseInt(br.readLine());
		
		File outputFile = new File("C_Bathroom Stalls/C-small-practice-2.out");
		bw = new BufferedWriter(new FileWriter(outputFile));
		int caseNumber = 1;
		while(caseNumber<=T) {
			System.out.println(String.format("Processing Case #%d", caseNumber));
			String[] ss = br.readLine().split("\\s+");
			int N = Integer.parseInt(ss[0]);
			int K = Integer.parseInt(ss[1]);
			
			stallSet = new LinkedHashSet<Stall>();
			for(int i = 0;i<N;i++) {
				stallSet.add(new Stall(i));
			}
			
			int[] result = new int[2];
			for(int j = 0;j<K;j++) {
				result = makeDecision();
				/*
				if(j== K-1) {
					System.out.println("The last guy chooses the stall with " + result[0] +" and " + result[1]);
				}
				*/
			}
			
		
			
			bw.write(String.format("Case #%d: %d %d",caseNumber,result[0],result[1]));
			bw.newLine();
			
			
			caseNumber++;
		}
		
		bw.close();
		br.close();

	}

	private static int[] makeDecision() {

		Stall[] stallSetArray = stallSet.toArray(new Stall[stallSet.size()]); //Making it easier to work with
		
		for(Stall s : stallSet) {
			int count = 0;
			int id = s.getID();
			// Count left empty stalls
			for(int i = id-1;i>=0;i--) {
				if(stallSetArray[i].isOccupied()==false) {
					count++;
				}else {
					break;
				}
			}
			s.setLs(count);
			count = 0;
			// Count right empty stalls
			for(int i = id+1;i<stallSetArray.length;i++) {
				if(stallSetArray[i].isOccupied()==false) {
					count++;
				}else {
					break;
				}
			}
			s.setRs(count);
			
			s.calculateminMax();
			
		}
		// Adding to the set of maximum minimums 
		List<Stall> minSet = new LinkedList<Stall>();
		int max = Integer.MIN_VALUE;
		for(Stall s : stallSet) {
			if(s.occupied == false) {
				if(s.min > max) {
					max = s.min;
				}
			}
		}
		for(Stall s : stallSet) {
			if(s.occupied == false && s.min == max) {
				minSet.add(s);
			}
		}
		
		// Actually making the decision
		if(minSet.size()==1) {
			// Only 1 stall YAY
			Stall s = minSet.get(0);
			for(Stall ss : stallSet) {
				if(ss.ID == s.ID) {
					ss.setOccupied(true);
					return new int[] {ss.max,ss.min};
				}
			}	
		}else {
			// More than 1 stalls with max minimums.
			// Run through the maxSet
			List<Stall> maxSet = new LinkedList<Stall>();
			max = Integer.MIN_VALUE;
			for(Stall s : minSet) {
				if(s.occupied == false) {
					if(s.max > max) {
						max = s.max;
					}
				}
			}
			for(Stall s : minSet) {
				if(s.occupied == false && s.max == max) {
					maxSet.add(s);
				}
			}
			
			Stall s = maxSet.get(0);
			for(Stall ss: stallSet) {
				if(ss.ID == s.ID) {
					ss.setOccupied(true);
					return new int[] {ss.max,ss.min};
				}
			}
			
			
		}
		return null;
		
		
	
		
		
		
		
		
		
	}

}

class Stall{
	final int ID;
	int Ls;
	int Rs;
	int min;
	int max;
	boolean occupied;
	
	public Stall(int id) {
		this.ID = id;
		occupied = false;
		Ls = -1;
		Rs = -1;
		
	}
	public int getID() {
		return ID;
	}

	public void calculateminMax() {
		min = Math.min(Ls, Rs);
		max = Math.max(Ls, Rs);
		
	}

	public int getLs() {
		return Ls;
	}

	public void setLs(int ls) {
		Ls = ls;
	}

	public int getRs() {
		return Rs;
	}

	public void setRs(int rs) {
		Rs = rs;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	 
	
}
