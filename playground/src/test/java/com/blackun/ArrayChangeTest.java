package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class ArrayChangeTest {

	int arrayChange(int[] inputArray) {
		int num = 0;
		for(int i =1; i<inputArray.length; i++){
			if(inputArray[i-1] < inputArray[i]) continue;
			int addNum = inputArray[i-1] - inputArray[i] + 1;
			inputArray[i] += addNum;
			num += addNum;
		}
		return num;
	}

	@Test
	public void test(){
		int[] inputArray = {1, 1, 1};
		int expected = arrayChange(inputArray);

		Assert.assertEquals(expected, 3);
	}

	@Test
	public void test2(){
		int[] inputArray = {-1000, 0, -2, 0};
		int expected = arrayChange(inputArray);

		Assert.assertEquals(expected, 5);
	}

	@Test
	public void test3(){
		int[] inputArray = {2, 1, 10, 1};
		int expected = arrayChange(inputArray);

		Assert.assertEquals(expected, 12);
	}
}
