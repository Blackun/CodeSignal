package com.blackun;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class MakeAreaTest {

	int makeArrayConsecutive2(int[] statues) {
		Arrays.sort(statues);
		return statues[statues.length-1] - statues[0] + 1 - statues.length;
	}

	@Test
	public void test1(){
		int expected = makeArrayConsecutive2(new int[]{6,2,3,8});
		Assert.assertEquals(expected, 3);
	}
}
