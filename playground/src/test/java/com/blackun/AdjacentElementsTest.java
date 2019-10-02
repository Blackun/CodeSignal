package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AdjacentElementsTest {
	int adjacentElementsProduct(int[] inputArray) {
		int largestProduct = inputArray[0] * inputArray[1];
		for(int i = 1; i<inputArray.length-1; i++){
			int product = inputArray[i] * inputArray[i+1];
			largestProduct = product > largestProduct ? product : largestProduct;
		}
		return largestProduct;
	}

	@Test
	public void test1(){
		int expected = adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3});
		Assert.assertEquals(expected, 21);
	}

	@Test
	public void test8(){
		int expected = adjacentElementsProduct(new int[]{-23, 4, -3, 8, -12});
		Assert.assertEquals(expected, -12);
	}

}
