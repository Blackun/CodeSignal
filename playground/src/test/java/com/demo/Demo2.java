package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {

	private static final Logger logger = LogManager.getLogger(Demo2.class);

	ObjectMapper mapper = new ObjectMapper();
	long start =0;
	long end = 0;

	@Before
	public void before(){
		start = System.nanoTime();
	}

	@After
	public void after(){
		end = System.nanoTime();
		long diff = end - start;
		logger.info("time : {} ms", diff / 1_000_000);
	}

	public int solution(String S){
		int K = S.indexOf("(");
		return K;
	}

	@Test
	public void test1() throws IOException {
		String S = "(())";
		int ret = solution(S);
		logger.info("ret = {}", mapper.writeValueAsString(ret));
	}

	public int solution2(int[] A) {
		int castles = 1;
		int tilt = 0;
		int prev = A[0];
		for (int i=1; i<A.length; i++) {
			if (A[i] > prev) {
				if (tilt != 1) {
					tilt = 1;
					castles ++;
				}
			} else if (A[i] < prev) {
				if (tilt != -1) {
					tilt = -1;
					castles ++;
				}
			}
			prev = A[i];
		}

		return castles;
	}

	@Test
	public void test2() throws IOException {
		int[] A = {-1000000000, 2,2,3,4,3,3,2,2,1,1,2,5,1000000000};
		//int[] A = {-1000000000};
		int ret = solution2(A);
		logger.info("ret = {}", mapper.writeValueAsString(ret));
	}

	public int solution3(int[] A) throws IOException {
		List<Integer> aList = Arrays.stream(A).boxed().collect(Collectors.toList());
		//logger.info("aList = {}", mapper.writeValueAsString(aList.size()));
		// List<Integer> subList = aList.subList(1, aList.size()-1).stream().sorted().collect(Collectors.toList());
		//logger.info("subList = {}", mapper.writeValueAsString(subList));
		return aList.subList(1, aList.size()-1).stream().sorted().limit(2).collect(Collectors.summingInt(Integer::intValue));

	}

	public int solution3_1(int[] A){
		int[] PQ = {A[1], A[2]};
		for(int i=3; i<A.length-1; i++){
			if(A[i] < PQ[0]){
				PQ[0] = A[i];
				continue;
			}
			if(A[i] < PQ[1]){
				PQ[1] = A[i];
				continue;
			}
		}
		return PQ[0] + PQ[1];
	}

	@Test
	public void test3() throws IOException {
		int[] A = {1,5,2,4,6,3,7,1};
		int ret = solution3(A);
		logger.info("ret = {}", ret);
		Assert.assertEquals(5, ret);
	}

	@Test
	public void test3_1() throws IOException {
		int[] A = {1,5,2,4,6,3,7,1};
		int ret = solution3_1(A);
		logger.info("ret = {}", ret);
		Assert.assertEquals(5, ret);
	}


	public int solution4(String S) {
		int leftIndex = S.indexOf("(");
		if(leftIndex < 0) return S.length();

		int rightIndex = S.lastIndexOf(")");
		int tempLeftIndex=0;
		int tempRightIndex=0;
		for(int i=0; i<S.length()/2; i++){
			logger.info("leftIndex : {}, rightIdex : {}", leftIndex, rightIndex);
			tempLeftIndex = S.indexOf("(", leftIndex+1);
			tempRightIndex = S.lastIndexOf(")", rightIndex-1);

			if(tempLeftIndex > tempRightIndex) break;
			if(tempLeftIndex < 0 || tempRightIndex<0) break;

			leftIndex = tempLeftIndex > 0 && tempLeftIndex > leftIndex ? tempLeftIndex : leftIndex;
			rightIndex = tempRightIndex > 0 && tempRightIndex < rightIndex ? tempRightIndex : rightIndex;
		}
		return tempLeftIndex > 0 && tempLeftIndex < rightIndex ? tempLeftIndex : rightIndex;
	}

	@Test
	public void test4() throws IOException {
		String S = ")(()()))()())(";
		//String S = "(())";
		//String S = "(())))(";
		//String S = "))";
		int ret = solution4(S);
		logger.info("ret = {}", ret);
		logger.info("left = {}, right = {}", S.substring(0, ret), S.substring(ret, S.length()));
	}

}
