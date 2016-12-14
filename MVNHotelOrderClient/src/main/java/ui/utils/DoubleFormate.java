package ui.utils;

public class DoubleFormate {
		public static String  formateto(double db){
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
			return df.format(db);
		}
}
