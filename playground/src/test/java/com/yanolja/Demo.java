package com.yanolja;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

	private static final Logger logger = LogManager.getLogger(Demo.class);

	ObjectMapper mapper = new ObjectMapper();
	long start =0;
	long end = 0;


	int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber + n/2) % n;
	}


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


	@Test
	public void test1() throws IOException {
		int ret =circleOfNumbers(10, 2);
		logger.debug("ret : {}", mapper.writeValueAsString(ret));
	}

	public int solution(int[] A){
		int result = 0;
		List<Integer> lst = Arrays.stream(A).boxed().collect(Collectors.toList());
		lst.sort(null);

		boolean find = true;
		int before = 0;

		for (int a : lst) {
			if (a > 0) {
				if (a > 1 && find) {
					return 1;
				} else {
					find = false;
					if (a - before > 1) {
						return before + 1;
					}
				}
				before = a;
			}
		}

		if (before == 0) {
			result = 1;
		} else {
			result = before + 1;
		}
		return result;
	}

	@Test
	public void test2() throws IOException {
		int[] A = {1,3,6,4,1,2};
		int ret =solution(A);
		logger.debug("ret : {}", mapper.writeValueAsString(ret));
	}

	@Test
	public void test3() throws IOException {
		int[] A = {1,2,3};
		int ret =solution(A);
		logger.debug("ret : {}", mapper.writeValueAsString(ret));
	}
}
