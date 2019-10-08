package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AlmostIncreasingTest {
	boolean almostIncreasingSequence(int[] sequence) {

		if(sequence.length<=2)  return true;

		int removeIndex = -1;
		for(int i=1; i<sequence.length-1; i++){
			if(sequence[i-1] <= sequence[i] && sequence[i] >= sequence[i+1]){
				if(sequence[i-1] >= sequence[i+1]) removeIndex = i+1;
				else removeIndex = i;
				break;
			} else if(sequence[i-1] >= sequence[i] && sequence[i] >= sequence[i+1]){
				return false;
			}
		}

		if(removeIndex < 0 ) return true;

		int[] temp = new int[sequence.length-1];
		int tempIndex = 0;
		for(int i=0; i<sequence.length; i++){
			if(i==removeIndex) continue;
			temp[tempIndex++] = sequence[i];
		}

		for(int i=0; i<tempIndex-1; i++){
			if(temp[i] >= temp[i+1]) return false;
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

	@Test
	public void test16(){
		boolean expected = almostIncreasingSequence(new int[]{1,2,3,4,3,6});
		Assert.assertEquals(expected, true);
	}

	@Test
	public void test31(){
		boolean expected = almostIncreasingSequence(new int[]{6,5,4});
		Assert.assertEquals(expected, false);
	}


}
