package com.wyc.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	/*
	 * 方法1：批量关闭流，参数能传无限个。(3分) 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	 */
	public static void closeAll(AutoCloseable... ables) {

		if (null != ables && ables.length > 0) {

			for (AutoCloseable autoCloseable : ables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	 */
	public static String readTextFile(InputStream src) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int x = 0;
		try {
			// -1 表示读完
			while ((x = src.read(b)) != -1) {
				out.write(b);
			}

			return out.toString("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关流
			closeAll(out,src);
		}

		return null;
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) {
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(txtFile);
			return readTextFile(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	/**
	 * 一行行读取数据返回的结果集
	 * @Title: readFile 
	 * @Description: TODO
	 * @param in
	 * @return
	 * @return: List<String>
	 */
	public static List<String> readFile(InputStream in) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		List<String> list = new ArrayList<String>();
		String lineText = null;
		try {
			while ((lineText = reader.readLine()) != null) {

				list.add(lineText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

}
