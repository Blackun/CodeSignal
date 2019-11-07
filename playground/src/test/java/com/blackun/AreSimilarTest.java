package com.blackun;

import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class AreSimilarTest {
	boolean areSimilar(int[] a, int[] b) {
		List<Integer> swapIndexes = new ArrayList<>();
		for(int i=0; i<a.length; i++) {
			if (a[i] != b[i]) {
				if (swapIndexes.size() == 2)
					return false;
				swapIndexes.add(i);
			}
		}
		if(swapIndexes.size() == 0) return true;
		if(a[swapIndexes.get(0)] == b[swapIndexes.get(1)] && a[swapIndexes.get(1)] == b[swapIndexes.get(0)]) return true;
		return false;
	}


	@Test
	public void test(){
		int[] a = {4, 6, 3};
		int[] b = {3, 4, 6};

		boolean result = areSimilar(a, b);
		Assert.assertEquals(result, false);
	}
}
