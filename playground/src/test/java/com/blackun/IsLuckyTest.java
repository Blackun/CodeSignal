package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class IsLuckyTest {

	boolean isLucky(int n) {
		String num = String.valueOf(n);

		int firstSum = 0;
		int lastSum = 0;
		int length = num.length();
		for(int i=0; i<length/2; i++){
			firstSum += Integer.valueOf(num.charAt(i));
			lastSum += Integer.valueOf(num.charAt(length-1-i));
		}
		return firstSum == lastSum;
	}

	@Test
	public void test1(){
		int n = 1230;

		boolean expected = isLucky(n);
		Assert.assertEquals(expected, true);
	}
}
