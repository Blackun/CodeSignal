package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class CenturyTest {

	int centuryFromYear(int year) {
		return (year / 100) + (year%100 > 0 ? 1 : 0) ;
	}

	@Test
	public void test1(){
		int century = centuryFromYear(1905);

		Assert.assertEquals(20, century);
	}

}
