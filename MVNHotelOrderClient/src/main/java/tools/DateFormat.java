package tools;

import java.util.Date;

/**
 * 格式化日期的值，只提供静态方法
 * @author zjy
 *
 */
public class DateFormat {

	/**
	 * 返回year-mounth-date格式
	 * @param date 日期
	 * @return 格式化的字符串
	 */
	public static String format(Date date) {
		return date.getYear()+"-"+date.getMonth()+"-"+date.getDate();
	}
	
	public static String format_includingTime(Date date) {
		return format(date)+" "+date.getHours()+":"+date.getMinutes();
	}
}
