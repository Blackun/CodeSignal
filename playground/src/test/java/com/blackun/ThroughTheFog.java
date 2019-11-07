package com.blackun;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ThroughTheFog {

	private static final Logger logger = LogManager.getLogger(ThroughTheFog.class);

	ObjectMapper mapper = new ObjectMapper();

	int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber + n/2) % n;
	}

	@Test
	public void test1() throws IOException {
		int ret =circleOfNumbers(10, 2);
		System.out.println(mapper.writeValueAsString(ret));
	}

	int depositProfit(int deposit, int rate, int threshold) {
		for(int i=0; ;i++){
			int temp = (int)(deposit * Math.pow(1+rate/100.0, i));
			if(temp>=threshold) return i;
		}
	}

	@Test
	public void test2() throws IOException {
		int ret =depositProfit(100, 1, 101);
		System.out.println(mapper.writeValueAsString(ret));
	}


	int neighbouringElements(int[][] a) {
		int ret = 0;
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[0].length; j++){
				if(j+1<a[0].length && a[i][j] == a[i][j+1]) ret++;
				if(i+1<a.length && a[i][j] == a[i+1][j]) ret++;
			}
		}

		return ret;
	}

	@Test
	public void test3() throws IOException {
		int[][] a = {{1,1,1},{1,1,1},{1,1,1}};
		int ret =neighbouringElements(a);
		System.out.println(mapper.writeValueAsString(ret));
	}

	int absoluteValuesSumMinimization(int[] a) {
		return IntStream.of(a)
				.mapToObj(n->Collections.singletonMap(n, IntStream.of(a).map(a1->Math.abs(a1-n)).sum()))
				.flatMap(m->m.entrySet().stream())
				.min(Map.Entry.comparingByValue())
				.get().getKey();
	}

	@Test
	public void test4(){
		int[] a = {2,4,7};
		int ret = absoluteValuesSumMinimization(a);
		logger.info("absoluteValuesSumMinimization({}) = {}", a, ret);
	}
}
