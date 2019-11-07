package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AlternatingSumsTest {

	int[] alternatingSums(int[] a) {
		int[] result = {0, 0};

		for(int i=0; i<a.length; i++){
			result[i%2]+=a[i];
		}

		return result;
	}

	@Test
	public void test(){
		int[] a = {50, 60, 60, 45, 70};
		int[] result = alternatingSums(a);

		Assert.assertEquals(result[0], 180);
		Assert.assertEquals(result[1], 105);
	}
}
