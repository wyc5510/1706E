package com.wyc.common.utils;

import java.util.Calendar;
import java.util.Date;
/**
日期处理类......
*/
//远程
public class DateUtil {
	/**
	 * 
	 * @Title: getDateByMonthSub 
	 * @Description: 把传入的日期减去对应月份
	 * @param month
	 * @return
	 * @return: Date
	 */
	public static Date getDateByMonthSub(Date date ,Integer month) {
		  
		  Calendar c = Calendar.getInstance();
		  //用传入的日期初始化日历类
		  c.setTime(date);
		  //减去传入月份
		  c.add(Calendar.MONTH, - month);
		  return c.getTime();
	}
	
	
	
	/*
	 * 方法1：(5分) 返回给定日期的月初 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 */
	public static Date getDateByInitMonth(Date src) {
		// 用当前系统时间获取日历类
		Calendar c = Calendar.getInstance();
		// 用传入的变量初始化日历类
		c.setTime(src);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
		/*
		 * 方法2：(5分) 返回给定日期月末 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
		 * 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
		 * 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
		 */
		public static Date getDateByFullMonth(Date src) {
			// 用当前系统时间获取日历类
			Calendar c = Calendar.getInstance();
			// 用传入的变量初始化日历类
			c.setTime(src);
	       //让月份加1 
			c.add(Calendar.MONTH, 1);
			//让月份变成月初
			Date date = getDateByInitMonth(c.getTime());
			//再用月初初始化日历类
			c.setTime(date);
			//让秒减一
			c.add(Calendar.SECOND, -1);
			return c.getTime();
		}

		
		//思考题:随机返回18-60岁之间的日期
		
		//随机产生在某个时间段内的日期
		public static Date randomDate(Date minDate,Date maxDate) {
			
			Calendar c1 = Calendar.getInstance();
			
			//获取开始的时间的毫米数
			long l1 = minDate.getTime();
			//获取结束时间的毫米数
			long l2 = maxDate.getTime();
			
			//随机产生一个l1和l2之间的随机数据 l3
			
			long l3= (long) ((Math.random() * (l2-l1 +1 ))+l1);
			//用毫秒 初始化日历类
			c1.setTimeInMillis(l3);	
			
			return c1.getTime();
			
		}
		
		
		
	}



