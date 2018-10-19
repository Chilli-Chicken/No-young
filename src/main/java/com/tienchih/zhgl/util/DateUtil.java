package com.tienchih.zhgl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void setTimeZone() {
		// TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		// TimeZone.setDefault(tz);
	}

	/**
	 * 按yyyy-MM-dd样式获取当前日期
	 * 
	 * @return
	 */
	public static String getDate() {
		setTimeZone();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * 按yyyy-MM-dd HH:mm:ss样式获取当前时间
	 * 
	 * @return
	 */
	public static String getTime() {
		setTimeZone();
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 按yyyy-MM-dd样式解析日期字符串
	 * 
	 * @return
	 */
	public static Date parseDate(String dateStr, String farmat) {
		Date date = null;
		setTimeZone();
		try {
			if (!"".equals(farmat))
				date = new SimpleDateFormat(farmat).parse(dateStr);
			else
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 按yyyy-MM-dd HH:mm:ss样式解析时间字符串
	 * 
	 * @return
	 */
	public static Date parseTime(String dateStr) {
		Date date = null;
		setTimeZone();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String parseTime(long dateLong) {
		setTimeZone();
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dateLong));
	}

	/**
	 * 根据样式获取当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getDate(String format) {
		setTimeZone();
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 获取指定时间加上指定天数的时间字符串格式
	 * 
	 * @param time
	 *            时间的字符串
	 * @param pattern
	 *            时间格式
	 * @param days
	 *            天数
	 * @return
	 */
	public static String getTimeAddDay(String time, String format, int days) {
		setTimeZone();
		if (null == time) {
			time = getTime();
		}
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		String resultTime = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Date date = dateFormat.parse(time);
			Calendar cale = Calendar.getInstance();
			cale.setTime(date);
			// 指定时间内加上指定天数
			cale.add(Calendar.DAY_OF_MONTH, days);
			date = cale.getTime();
			// 结果时间的字符串格式
			resultTime = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultTime;
	}

	/**
	 * 根据时间获取该时间N天后的时间
	 * 
	 * @param time
	 *            时间
	 * @param days
	 *            天数
	 * @return
	 */
	public static String getTimeAddDay(String time, int days) {
		return getTimeAddDay(time, "yyyy-MM-dd HH:mm:ss", days);
	}

	/**
	 * 判断某一时间是否在当前时间之后
	 * 
	 * @param time
	 *            yyyy-MM-dd HH:mm:ss格式的字符串时间
	 * @return
	 */
	public static boolean isAfterNowTime(String time) {
		String nowTime = getTime();
		try {
			return time.compareTo(nowTime) > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断某一时间是否在当前时间之前
	 * 
	 * @param time
	 *            yyyy-MM-dd HH:mm:ss格式的字符串时间
	 * @return
	 */
	public static boolean isBeforeNowTime(String time) {
		String nowTime = getTime();
		try {
			return nowTime.compareTo(time) > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取当前时间N天后的时间
	 * 
	 * @param days
	 *            天数
	 * @return
	 */
	public static String getTimeAddDay(int days) {
		return getTimeAddDay(getTime(), days);
	}

	public static Date addYears(Date date, int amount) {
		return add(date, 1, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, 2, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, 3, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, 5, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, 11, amount);
	}

	public static Date addMinutes(Date date, int amount) {
		return add(date, 12, amount);
	}

	public static Date addSeconds(Date date, int amount) {
		return add(date, 13, amount);
	}

	public static Date addMilliseconds(Date date, int amount) {
		return add(date, 14, amount);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(calendarField, amount);
			return c.getTime();
		}
	}

	/**
	 * 根据当前时间来计算剩余天数
	 * 
	 * @param endDate
	 * @return add by sun
	 */
	public static int getRemainDays(String endDate, String farmat) {
		long millisDiff = parseDate(endDate, farmat).getTime() - System.currentTimeMillis();
		return getDayCountByMillis(millisDiff);
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static int getDayCount(String fromDate, String toDate, String farmat) {
		long millisDiff = parseDate(toDate, farmat).getTime() - parseDate(fromDate, farmat).getTime();
		return getDayCountByMillis(millisDiff);
	}

	/**
	 * 根据时间差（毫秒）计算相差天数
	 * 
	 * @param timeDiff
	 * @return
	 */
	private static int getDayCountByMillis(long timeDiff) {
		int result = 0;
		int c = timeDiff < 0 ? -1 : 1;
		long millisOfDay = (24 * 1000 * 3600);
		// 相差不到24小时
		if (Math.abs(timeDiff) < millisOfDay) {
			result = 1; // 不足24小时算一天
		} else {
			result = (int) (Math.abs(timeDiff) / millisOfDay) + (Math.abs(timeDiff) % millisOfDay > 0 ? 1 : 0);
		}
		return result * c;
	}
	
	public static String formatDate(Date date, String farmat) {
		String result = "";
		if (!"".equals(farmat))
			result = new SimpleDateFormat(farmat).format(date);
		else
			result = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return result;
	}
	
	public static String randomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 构造开始日期
			Date end = format.parse(endDate);// 构造结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
//			Date date2 = new Date(date);
			return parseTime(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}

	public static void main(String[] args) {
//		int remainDays = DateUtil.getRemainDays("2016年6月15日)", "yyyy年MM月dd日");
//		System.out.println(remainDays);
//		System.out.println(DateUtil.getDate());
		Date addDays = addDays(new Date(), -1);
		String formatDate = formatDate(addDays, "yyyy-MM-dd HH:mm:ss");
		String randomDate = randomDate(formatDate, getTime());
//		System.out.println(formatDate);
//		System.out.println(getTime());
		for (int i = 0; i < 10; i++) {
			System.out.println(randomDate);
		}
	}

}
