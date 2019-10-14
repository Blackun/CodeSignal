package com.blackun;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class ReverseInParenthesesTest {

	String reverseInParentheses(String inputString) {
		Pattern p = Pattern.compile("\\([^\\(\\)]*\\)");
		Matcher m = p.matcher(inputString);
		while(m.find()){
			int startIndex = m.start();
			int endIndex = m.end();
			String matched = inputString.substring(startIndex, endIndex);
			String replaced = new StringBuilder(inputString.substring(startIndex+1, endIndex-1)).reverse().toString();
			inputString = inputString.replace(matched, replaced);
			m = p.matcher(inputString);
		}
		return inputString;
	}

	@Test
	public void test1(){
		String expected = reverseInParentheses("(bar)");
		Assert.assertEquals(expected, "rab");
	}

	@Test
	public void test2(){
		String expected = reverseInParentheses("foo(bar)baz");
		Assert.assertEquals(expected, "foorabbaz");
	}

	@Test
	public void test3(){
		String expected = reverseInParentheses("foo(bar)baz(blim)");
		Assert.assertEquals(expected, "foorabbazmilb");
	}

	@Test
	public void test4(){
		String expected = reverseInParentheses("foo(bar(baz))blim");
		Assert.assertEquals(expected, "foobazrabblim");
	}

	@Test
	public void test6(){
		String expected = reverseInParentheses("()");
		Assert.assertEquals(expected, "");
	}

	@Test
	public void test14(){
		String expected = reverseInParentheses("(())");
		Assert.assertEquals(expected, "");
	}

}
