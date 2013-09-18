package set;

import java.util.Arrays;
import java.util.Iterator;

public class Unique {
	public static int[] uniqueElementsArraySort(int[] ints) {
		MaxSet<Integer> set = new MaxSet<Integer>();
		
		Arrays.sort(ints);
		
		for(int i : ints) {
			set.add(i);
		}
		
		int[] output = new int[set.size()];
		int i = 0;
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			output[i++] = itr.next();
		}
		
		return output;
	}
	
	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> set = new MaxSet<Integer>();
				
		for(int i : ints) {
			set.add(i);
		}
		
		int[] output = new int[set.size()];
		
		for(int i = output.length-1; i >= 0; i--) {
			output[i] = set.getMax();
			set.remove(output[i]);
		}
		
		return output;
	}
}
