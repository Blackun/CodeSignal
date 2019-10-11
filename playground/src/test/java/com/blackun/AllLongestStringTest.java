package com.blackun;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AllLongestStringTest {

	String[] allLongestStrings(String[] inputArray) {

		List<String> array = new ArrayList<String>();

		int longest = 0;
		for(String str : inputArray){
			if(str.length() > longest){
				longest = str.length();
				array.clear();
			}
			if(str.length() == longest){
				array.add(str);
			}
		}

		return array.stream().toArray(String[]::new);
	}

	@Test
	public void test1(){
		String[] intputArray = {"aba",
				"aa",
				"ad",
				"vcd",
				"aba"};
		String[] expected = allLongestStrings(intputArray);

		Assert.assertEquals(expected[0], "aba");
	}
}
