package com.blackun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class SortByHeightTest {

	int[] sortByHeight(int[] a) {
		LinkedList<Integer> list = Arrays.stream(a).boxed().filter(x->x>-1).sorted().collect(Collectors.toCollection(LinkedList::new));

		int[] b = new int[a.length];

		for(int i=0; i<a.length; i++){
			b[i] = a[i] > -1 ? list.pop().intValue(): a[i];

		}

		return b;
	}


	@Test
	public void test1(){
		int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};

		int[] expected = sortByHeight(a);
		Assert.assertEquals(expected[1], 150);
	}

}
