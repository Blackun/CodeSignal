package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AreEquallyStrongTest {

	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		int[] a = new int[4];
		a[0] = yourLeft > yourRight ? yourLeft : yourRight;
		a[1] = yourLeft > yourRight ? yourRight : yourLeft;
		a[2] = friendsLeft > friendsRight ? friendsLeft : friendsRight;
		a[3] = friendsLeft > friendsRight ? friendsRight : friendsLeft;

		return a[0] == a[2] && a[1] == a[3];
	}

	@Test
	public void test(){
		boolean expected = areEquallyStrong(10, 15,15, 10);
		Assert.assertEquals(expected, true);
	}

}
