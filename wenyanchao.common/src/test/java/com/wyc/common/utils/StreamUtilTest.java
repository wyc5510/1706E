package com.wyc.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testCloseAll() {
		long l1 = new Date().getTime();
		System.out.println("l1="+l1);

		//获取结束时间的毫米数
		long l2 = new Date(1000000).getTime();
		System.out.println("l2="+l2);
		for (int i =0;i<100;i++) {
			System.out.println(Math.random() *(l1-l2));
			
		}
		
	}

	@Test
	public void testReadTextFileInputStream() throws FileNotFoundException {
		String string = StreamUtil.readTextFile(new  FileInputStream("e:/test.txt"));
		System.out.println(string);
	}

	@Test
	public void testReadTextFileFile() {
		String string = StreamUtil.readTextFile(new File("e:/test.txt"));
		System.out.println(string);
	}

}
