package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class MatrixElementsSumTest {

	int matrixElementsSum(int[][] matrix) {
		return 0;
	}

	@Test
	public void test1(){
		int[][] matrix = {{1, 1, 1, 0}, {0, 5, 0, 1},{2, 1, 3, 10}};
		int expected = matrixElementsSum(matrix);
		Assert.assertEquals(expected, 9);
	}


}
