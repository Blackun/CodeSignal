package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class MatrixElementsSumTest {

	int matrixElementsSum(int[][] matrix) {
		int sum = 0;
		boolean[] isHaunted = new boolean[matrix[0].length];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j] == 0) {
					isHaunted[j] = true;
					continue;
				}
				if(isHaunted[j]==false) sum += matrix[i][j];
			}
		}
		return sum;
	}

	@Test
	public void test1(){
		int[][] matrix = {{1, 1, 1, 0}, {0, 5, 0, 1},{2, 1, 3, 10}};
		int expected = matrixElementsSum(matrix);
		Assert.assertEquals(expected, 9);
	}


}
