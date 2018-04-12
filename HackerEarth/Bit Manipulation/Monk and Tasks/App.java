import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Triple{
	private long count;
	private long element;
	private long index;
	
	public Triple(long count, long element, long index){
		this.count = count;
		this.element = element;
		this.index = index;
		
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getElement() {
		return element;
	}

	public void setElement(long element) {
		this.element = element;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}
	
	
}
class tripleComparator implements Comparator<Triple>{

	@Override
	public int compare(Triple o1, Triple o2) {
		if(o1.getCount()<o2.getCount()){
			return -1;
		}else if(o1.getCount()>o2.getCount()){
			return 1;
		}else{
			if(o1.getIndex()<o2.getIndex()){
				return -1;
			}else{
				return 1;
			}
		}
	}
	
}



public class App {
	
	

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++){
				long[] arr = solver(Integer.parseInt(br.readLine()), br.readLine().split("\\s+"));
				for(long a : arr){
					System.out.print(a+" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

	private static long[] solver(int N, String[] split) {
		long[] arr = new long[N];
		long[] binrep = new long[N];
		List<Triple> triples = new ArrayList<Triple>();
		
		for(int i = 0; i<N;i++){
			arr[i]=Long.parseLong(split[i]);
			binrep[i] = countOnes(arr[i]);
			
			triples.add(new Triple(binrep[i],arr[i],i));
			
				
		}
		
		Collections.sort(triples,new tripleComparator());
		
		long[] ans = new long[N];
		for(int i = 0;i<triples.size();i++){
			ans[i] = triples.get(i).getElement();
		}
		
		
		return ans;
	}

	private static int countOnes(long i) {
		int count = 0;
		while(i != 0){
			i = i&(i-1);
			count++;
		}
		return count;
	}

}
