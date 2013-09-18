package test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import set.Unique;

public class TestUniqueElements {
	int[] ints = {7, 5, 3, 5, 2, 2, 7 };
	int[] output = {2, 3, 5, 7};
	
	@Before
	public void setUp() throws Exception {
		ints = new int[200000];

		for(int d = 0; d < 10; d++) {
			for(int i = 0; i < ints.length/10; i++) {
				ints[i] = i;
			}
		}
		
		output = new int[ints.length/10];
		for(int i = 0; i < output.length; i++) {
			output[i] = i;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testUniqueElements() {
		int[] result = Unique.uniqueElements(ints);
		
		for(int i = 0; i < result.length; i++)  {
			assertEquals("Mismatch", output[i], result[i]);
		}
	}
	
	@Test
	public final void testUniqueElementsArraySort() {
		int[] result = Unique.uniqueElementsArraySort(ints);
		
		for(int i = 0; i < result.length; i++)  {
			assertEquals("Mismatch", output[i], result[i]);
		}
	}
}
