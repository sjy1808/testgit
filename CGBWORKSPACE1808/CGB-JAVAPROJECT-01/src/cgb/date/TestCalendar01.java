package cgb.date;

import java.util.Calendar;

public class TestCalendar01 {

	public static void main(String[] args) {
		Calendar c1=Calendar.getInstance();
		System.out.println(c1);
		long time=c1.getTimeInMillis();
		System.out.println(time);
		int hour=c1.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
	}
}
