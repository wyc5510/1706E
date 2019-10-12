package com.wyc.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {

		for(int i =0;i<10;i++) {
		int j = RandomUtil.random(1,9);
		System.out.println(j);
		}
	}

	@Test
	public void testSubRandom() {
		
			int[] subRandom = RandomUtil.subRandom(1, 10, 3);
			for (int i : subRandom) {
				System.out.print(i+" ");
			}
			
	}

	@Test
	public void testRandomCharacter() {
		char c = RandomUtil.randomCharacter();
		System.out.println(c);
	}

	@Test
	public void testRandomString() {
		String string = RandomUtil.randomString(4);
		System.out.println(string);
	}

}
