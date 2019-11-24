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


	void printMultiNumber(int n) {
		for (int i = 1; i <= n; i++) {
			boolean isprint = false;
			if (i % 2 == 0) {
				isprint = true;
				System.out.print("Codility");
			}

			if (i % 3 == 0) {
				isprint = true;
				System.out.print("Test");
			}

			if (i % 5 == 0) {
				isprint = true;
				System.out.print("Coders");
			}

			if (isprint) {
				System.out.println();
			} else {
				System.out.println(i);
			}
		}
	}

	int returnHillvallycount() {
		List<Integer> A = Arrays.asList(2,1,3,4,3,2,1,1,2,3,4,5,4);

		int countCasle = 1;
		int positive = 0;
		int befor = A.get(0);
		for (int i : A) {
			if (i > befor) {
				if (positive != 1) {
					positive = 1;
					countCasle ++;
				}
			} else if (i < befor) {
				if (positive != -1) {
					positive = -1;
					countCasle ++;
				}
			} else {
				positive = 0;
			}
		}

		return countCasle;
	}



	@Test
	public void test1() throws IOException {
		int ret =returnHillvallycount();
		//printMultiNumber(24);
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