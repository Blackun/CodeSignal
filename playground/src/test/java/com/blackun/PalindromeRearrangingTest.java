package com.blackun;

import java.util.Arrays;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class PalindromeRearrangingTest {

	boolean palindromeRearranging(String inputString) {
		Map<String, Long> charCountMap = Arrays.stream(inputString.split("")).collect(groupingBy(e->e, counting()));
		long count = charCountMap.entrySet().stream().filter(e->e.getValue()%2==1).count();
		return count < 2;
	}

	@Test
	public void test1(){
		String inputString = "abbcabb";
		boolean expected = palindromeRearranging(inputString);
		Assert.assertEquals(expected, true);
	}
}
