package map;

import java.util.Random;

public class MAINMETODEN {
	public static void main(String[] args) {
		SimpleHashMap map = new SimpleHashMap(10);
		
		addNumbers(map);
		
		System.out.println(map.show());
		
		addNumbers(map);
		addNumbers(map);

		System.out.println(map.show());
		
		map.get("STRINGFEST");
		// NO CRASH NO PROBLEM RIGHT
	}
	
	private static void addNumbers(SimpleHashMap map) {
		Random rng = new Random();
		
		for(int i = 0; i < 5; i++) {
			int rnd = rng.nextInt(255) * ((i%2) == 0 ? -1 : 1) ;
			
			map.put(rnd, rnd);
		}
	}
}
