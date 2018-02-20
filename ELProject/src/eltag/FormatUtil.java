package eltag;

import java.text.DecimalFormat;

public class FormatUtil {

	public static String number(long number, String pattern) {

		DecimalFormat formatter = new DecimalFormat(pattern);		
			return formatter.format(number);
	}
	
	
}
