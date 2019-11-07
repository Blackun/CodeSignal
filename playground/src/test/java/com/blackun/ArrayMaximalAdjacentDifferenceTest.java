package com.blackun;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class ArrayMaximalAdjacentDifferenceTest {

	ObjectMapper mapper = new ObjectMapper();

	int arrayMaximalAdjacentDifference(int[] inputArray) {
		int maxAbs = 0;
		for(int i=1; i<inputArray.length; i++){
			int abs = Math.abs(inputArray[i] - inputArray[i-1]);
			maxAbs = maxAbs < abs ? abs : maxAbs;
		}
		return maxAbs;
	}

	boolean isIPv4Address(String inputString) {
		return inputString.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
	}

	@Test
	public void test1(){
		Assert.assertEquals(isIPv4Address("172.16.254.1"), true);
	}

	int avoidObstacles(int[] inputArray) {
		return IntStream.range(1, 1000).filter(n->IntStream.of(inputArray).filter(e->e%n==0).findAny().isPresent() == false).findAny().getAsInt();
	}

	@Test
	public void test2(){
		Assert.assertEquals(avoidObstacles(new int[]{1,4,10,6,2}), 7);
	}

	int[][] boxBlur(int[][] image) {
		int[][] result = new int[image.length-2][image[0].length-2];
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[0].length; j++){
				result[i][j]=(int)Math.floor((image[i][j]+image[i][j+1]+image[i][j+2]+image[i+1][j]+image[i+1][j+1]+image[i+1][j+2]+image[i+2][j]+image[i+2][j+1]+image[i+2][j+2])/9.0f);
			}
		}
		return result;
	}

	@Test
	public void test3(){
		int[][] image = {{1,1,1}, {1,7,1}, {1,1,1}};
		Assert.assertEquals(boxBlur(image)[0][0], 1);
	}

	int[][] minesweeper(boolean[][] matrix) {
		int[][] ret = new int[matrix.length][matrix[0].length];

		for(int i=0; i<ret.length; i++){
			for(int j=0; j<ret[0].length; j++){
				int k_min = (i-1 < 0) ? 0 : i-1;
				int k_max = (i+1 > ret.length-1) ? ret.length-1 : i+1;
				int l_min = (j-1 < 0) ? 0 : j-1;
				int l_max = (j+1 > ret[0].length-1) ? ret[0].length-1 : j+1;
				int mines = 0;
				for(int k=k_min; k<=k_max; k++){
					for(int l=l_min; l<=l_max; l++){
						if(k==i && l==j) continue;
						mines += matrix[k][l] ? 1 : 0;
					}
				}
				ret[i][j] = mines;
			}
		}

		return ret;
	}

	@Test
	public void test4() throws IOException {
		boolean[][] matrix = {{true,true,true}, {true,true,true}, {true,true,true}};
		System.out.println(mapper.writeValueAsString(matrix));
		int[][] ret = minesweeper(matrix);
		System.out.println(mapper.writeValueAsString(ret));
	}



}
