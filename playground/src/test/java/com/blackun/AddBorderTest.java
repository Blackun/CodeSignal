package com.blackun;

import org.junit.Assert;
import org.junit.Test;

public class AddBorderTest {

	String[] addBorder(String[] picture) {
		int width = picture[0].length()+2;
		int row = picture.length+2;
		String[] result = new String[picture.length+2];
		for(int i=0; i<picture.length; i++){
			result[i+1]= "*"+picture[i]+"*";
		}
		String border = "";
		for(int i=0; i<width; i++){
			border += "*";
		}
		result[0] = border;
		result[row-1] = border;
		return result;
	}

	@Test
	public void test(){
		String[] picture = {"abc","ded"};
		String[] result = addBorder(picture);

		Assert.assertEquals(result[0], "*****");
		Assert.assertEquals(result[1], "*abc*");
		Assert.assertEquals(result[2], "*ded*");
		Assert.assertEquals(result[3], "*****");
	}


}
