package ui.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.jfoenix.controls.JFXDatePicker;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tooltip;
import javafx.util.Callback;

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
		if(date==null){
			return null;
		}
		return String.valueOf(date.getYear())+"-"+String.valueOf(1+date.getMonth())+"-"+
				String.valueOf(date.getDate());
	}
	
	/**
	 * 返回year-mounth-date hours:minutes格式
	 * @param date 日期
	 * @return 格式化的字符串
	 */
	public static String format_includingTime(Date date) {
		if(date==null){
			return null;
		}
		return format(date)+" "+(date.getHours()<10?"0":"")+date.getHours()+":"+(date.getMinutes()<10?"0":"")+date.getMinutes();
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
	public static Date getDate(JFXDatePicker datePicker,JFXDatePicker timePicker) {
		if(datePicker.getValue()==null || timePicker.getTime()==null){
			return null;
		}
		return new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), 
				datePicker.getValue().getDayOfMonth(),timePicker.getTime().getHour(),
				timePicker.getTime().getMinute(),timePicker.getTime().getSecond());
	}
	
	/**
	 * 初始化日期选择器，使得退房日期一定在入住日期之后，且提示将要入住的天数
	 * @param checkInDatePicker 入住日期的日期选择器
	 * @param checkOutDatePicker 退房日期的日期选择器
	 */
	public static void initDatePicker(DatePicker checkInDatePicker,DatePicker checkOutDatePicker) {
		checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item.isBefore(
                                    checkInDatePicker.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }
                            long p = ChronoUnit.DAYS.between(
                                    checkInDatePicker.getValue(), item
                            );
                            setTooltip(new Tooltip(
                                "You're about to stay for " + p + " days")
                            );
                    }
                };
            }
        };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
	}
	
	@Deprecated
	public static void initTimePicker(DatePicker timePicker) {
		
	}
}
