package ui.utils;

import java.util.Date;

import com.jfoenix.controls.JFXDatePicker;

import javafx.scene.control.DatePicker;

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
	
	/**
	 * 返回year-mounth-date hours:minutes格式
	 * @param date 日期
	 * @return 格式化的字符串
	 */
	public static String format_includingTime(Date date) {
		return format(date)+" "+date.getHours()+":"+date.getMinutes();
	}
	
	/**
	 * 获取日期，只有年月日，时分秒都是0
	 * @param datePicker javafx的日期选择器
	 * @return 设置好值的Date对象
	 */
	public static Date getDate(DatePicker datePicker) {
		if(datePicker.getValue()==null){
			return null;
		}
		return new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), 
				datePicker.getValue().getDayOfMonth());
	}
	
	/**
	 * 获取日期，年月日，时分秒都有值
	 * @param datePicker Jfoenix的日期选择器
	 * @return 设置好值的Date对象
	 */
	public static Date getDate(JFXDatePicker datePicker) {
		if(datePicker.getValue()==null){
			return null;
		}
		return new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), 
				datePicker.getValue().getDayOfMonth(),datePicker.getTime().getHour(),
				datePicker.getTime().getMinute(),datePicker.getTime().getSecond());
	}
}
