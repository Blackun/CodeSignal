package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
	boolean checkPalindrome(String inputString) {
		return new StringBuffer(inputString).reverse().toString().compareTo(inputString) == 0;
	}

	@Test
	public void test1(){
		boolean expected = checkPalindrome("aabaa");
		Assert.assertEquals(expected, true);
	}
}
