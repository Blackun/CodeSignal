package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AlmostIncreasingTest {
	boolean almostIncreasingSequence(int[] sequence) {
		if(sequence.length == 2) return true;

		int notSequenceCount = 0;
		for(int i = 1; i<sequence.length-1; i++){
			if(sequence[i-1] >= sequence[i] || sequence[i] >= sequence[i+1]) notSequenceCount++;
			if(notSequenceCount>1) return false;
		}
		return true;
	}

	@Test
	public void test1(){
		boolean expected = almostIncreasingSequence(new int[]{1,3,2,1});
		Assert.assertEquals(expected, false);
	}

	@Test
	public void test2(){
		boolean expected = almostIncreasingSequence(new int[]{1,3,2});
		Assert.assertEquals(expected, true);
	}

	@Test
	public void test3(){
		boolean expected = almostIncreasingSequence(new int[]{1,2,1,2});
		Assert.assertEquals(expected, false);
	}

	@Test
	public void test13(){
		boolean expected = almostIncreasingSequence(new int[]{1,2,5,3,5});
		Assert.assertEquals(expected, true);
	}


}
