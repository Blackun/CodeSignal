package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class ReflectStringTest {

	String reflectString(String inputString) {
		String result = "";
		for(char c : inputString.toCharArray()){
			int reflect = c - 'a';
			char r = (char)('z' - reflect);
			result += r;
		}

		return result;
	}


	@Test
	public void test(){
		String inputString = "name";
		String expected = reflectString(inputString);

		Assert.assertEquals(expected, "mznv");
	}


}
