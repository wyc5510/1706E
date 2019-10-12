package com.wyc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void getDateByInitMonth() {
		
		
		Calendar c = Calendar.getInstance();
		c.set(2000, 1, 8);
		Date date = DateUtil.getDateByInitMonth(c.getTime());
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
		
		
	
	}
	
	//测试月末
	@Test
	public void getDateByFullMonth() {
		
		Calendar c = Calendar.getInstance();
		c.set(2018, 3, 8);
		Date date = DateUtil.getDateByFullMonth(c.getTime())	;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	
	@Test
	public void test1() {
		//获取月初
		Date date = DateUtil.getDateByInitMonth(new Date());
		Date date2 = DateUtil.getDateByFullMonth(new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		
		// 替换
		String string = sql.replace("{1}", df.format(date)).replace("{2}", df.format(date2));
		System.out.println(string);
		
	}
}
