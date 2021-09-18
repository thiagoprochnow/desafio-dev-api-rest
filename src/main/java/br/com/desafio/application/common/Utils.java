package br.com.desafio.application.common;

import java.util.Date;

public class Utils {

	public static Date getCurrentDate() {
		Date currentDate = new Date();
		currentDate.setHours(0);
		currentDate.setMinutes(0);
		currentDate.setSeconds(0);
		return currentDate;
	}
	
	public static boolean isPositiveNumber(float number) {
		return number > 0;
	}
}
