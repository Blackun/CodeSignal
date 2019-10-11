package com.blackun;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class CommonCharacterCountTest {
	int commonCharacterCount(String s1, String s2) {
		Set<String> s1Set = Arrays.stream(s1.split("")).collect(Collectors.toSet());
		List<String> s1List = Arrays.asList(s1.split(""));
		List<String> s2List = Arrays.asList(s2.split(""));
		return s1Set.stream().mapToInt(s->{
			long s1Count = s1List.stream().filter(x->s.equals(x)).count();
			long s2Count = s2List.stream().filter(x->s.equals(x)).count();
			return (int)(s1Count <= s2Count ? s1Count : s2Count);
		}).sum();

	}


	@Test
	public void test1(){
		String s1 = "aabcc";
		String s2 = "adcaa";

		int expected = commonCharacterCount(s1, s2);
		Assert.assertEquals(expected, 3);
	}
}
