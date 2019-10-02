package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class ShapeAreaTest {
	int shapeArea(int n) {
		if(n==1) return 1;
		int nArea = (int)Math.pow((n*2)-1, 2);
		int subArea = ((n-1)*n/2)*4;
		return  nArea - subArea;
	}

	@Test
	public void test1(){
		int expected = shapeArea(2);
		Assert.assertEquals(expected, 5);
	}

}
