package com.blackun;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

	int testGGuck() {
		int result = 0;

		List<Integer> lst = Arrays.asList(1,2,3,-1,5,-2,6,8,7);

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

		System.out.println(lst);

		return result;
	}

	@Test
	public void test4(){
		int[] a = {2,4,7};
		int ret = testGGuck();
		logger.info("absoluteValuesSumMinimization({}) = {}", 4, ret);
	}

	boolean stringsRearrangement(String[] inputArray) {
		List<String> source = Arrays.stream(inputArray).parallel().sorted().collect(Collectors.toList());
		List<String> ret = new ArrayList<>();
		for(int i=0; i<inputArray.length; i++){
			ret.add(source.remove(i));
			while(source.size()>0) {
				String next = findNext(source, ret.get(ret.size() - 1));
				if(next == null) break;
				ret.add(next);
				logger.info("ret : {}, source : {}", ret, source);
			}
			if(ret.size() == inputArray.length) return true;
			else {
				ret.clear();
				source = Arrays.stream(inputArray).parallel().sorted().collect(Collectors.toList());
			}
		}
		return false;
	}

	String findNext(List<String> source, String s){
		for(int i=0; i<source.size(); i++){
			if(oneCharDiff(source.get(i), s)){
				return source.remove(i);
			}
		}
		return null;
	}

	boolean oneCharDiff(String a, String b){
		int count = 0;
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i) != b.charAt(i)) count++;
		}
		return count==1;
	}

	@Test
	public void test0(){
		String[] inputArray = {"a", "b", "c", "c","c","b","a"};
		boolean ret = stringsRearrangement(inputArray);
		logger.info("stringsRearrangement({}) = {}", inputArray, ret);
		Assert.assertEquals(ret, true);
	}

	@Test
	public void test8(){
		String[] inputArray = {"ab","bb","aa"};
		boolean ret = stringsRearrangement(inputArray);
		logger.info("stringsRearrangement({}) = {}", inputArray, ret);
		Assert.assertEquals(ret, true);
	}

	@Test
	public void test06(){
		String[] inputArray = {"abc","bef","bcc","bec","bbc","bdc"};
		boolean ret = stringsRearrangement(inputArray);
		logger.info("stringsRearrangement({}) = {}", inputArray, ret);
		Assert.assertEquals(ret, true);
	}

}
