package com.blackun;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;

public class RainsOfReasonTest {
	ObjectMapper mapper = new ObjectMapper();

	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		int[] ret = new int[inputArray.length];
		for(int i=0; i<inputArray.length; i++){
			ret[i] = inputArray[i] == elemToReplace ? substitutionElem : inputArray[i];
		}

		return ret;
	}

	@Test
	public void test1() throws IOException {
		int[] inputArray = {1, 2, 1};
		int[] ret =arrayReplace(inputArray,1,3);
		System.out.println(mapper.writeValueAsString(ret));
	}

	boolean evenDigitsOnly(int n) {
		String temp = String.valueOf(n);
		return Arrays.stream(temp.split("")).filter(c->Integer.valueOf(c)%2==1).findAny().isPresent() == false;
	}

	@Test
	public void test2() throws IOException {
		int n=248622;
		boolean ret =evenDigitsOnly(n);
		System.out.println(mapper.writeValueAsString(ret));
	}

	boolean variableName(String name) {
		return name.matches("^[A-Za-z0-9_+]*$");
	}
	@Test
	public void test3() throws IOException {
		boolean ret =variableName("var_1__Int");
		System.out.println(mapper.writeValueAsString(ret));
	}

	String alphabeticShift(String inputString) {
		String ret= "";
		for(char c : inputString.toCharArray()){
			if(c=='z') ret += 'a';
			else ret+= (char)(c+1);
		}
		return ret;
	}

	@Test
	public void test4() throws IOException {
		String ret =alphabeticShift("crazy");
		System.out.println(mapper.writeValueAsString(ret));
	}

	boolean chessBoardCellColor(String cell1, String cell2) {
		char[] cell1s = cell1.toCharArray();
		char[] cell2s = cell2.toCharArray();

		int width = Math.abs(cell2s[0] - cell1s[0]);
		int height = Math.abs(cell2s[1] - cell1s[1]);
		return (width+height) %2 == 0;
	}

	@Test
	public void test5() throws IOException {
		boolean ret =chessBoardCellColor("A1", "C3");
		System.out.println(mapper.writeValueAsString(ret));
	}
}
