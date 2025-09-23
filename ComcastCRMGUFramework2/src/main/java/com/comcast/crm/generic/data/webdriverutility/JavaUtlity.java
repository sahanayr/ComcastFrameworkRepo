
package com.comcast.crm.generic.data.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtlity {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateyyyyMMddFormat() {
		Date dateObj = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	public String getRequiredDateyyyyMMddFormat(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
}
