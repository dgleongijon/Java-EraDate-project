package edu.sbcc.cs135;

import java.util.*;

public class EraDate {

	// INSTANCE VARIABLE
	private GregorianCalendar calendar = new GregorianCalendar();

	// CONSTRUCTOR
	public EraDate(int year, int month, int day) {
		// This constructor takes a four digit year, a month(1-12), and a
		// day(1-31)

		calendar.set(year, month, day);

	}

	public String getIso8601Date() {
		// Returns a String corresponding to the date specified in the
		// constructor.
		/**
		 * GregorianCalendar Iso = new GregorianCalendar(); int year = Iso.YEAR;
		 * int month = Iso.MONTH; int day = Iso.DAY_OF_MONTH; Iso.YEAR returns
		 * something. String date = String.format("%d-%d-%d ", year, month,
		 * day); return date;
		 **/
		return String.format("%04d-%02d-%02d", calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void printJapaneseEraName() {
		// Java looks at the dates by subtracting one from the month
		GregorianCalendar MeijiStart = new GregorianCalendar(1868, 1, 25);
		GregorianCalendar MeijiEnd = new GregorianCalendar(1912, 7, 30);
		GregorianCalendar TaishoStart = new GregorianCalendar(1912, 8, 1);
		GregorianCalendar TaishoEnd = new GregorianCalendar(1926, 12, 25);
		GregorianCalendar ShowaStart = new GregorianCalendar(1926, 12, 26);
		GregorianCalendar ShowaEnd = new GregorianCalendar(1989, 1, 7);
		GregorianCalendar HeiseiStart = new GregorianCalendar(1989, 1, 8);
		GregorianCalendar HeiseiEnd = new GregorianCalendar();

		if (calendar.getTimeInMillis() >= MeijiStart.getTimeInMillis()
				&& calendar.getTimeInMillis() <= MeijiEnd.getTimeInMillis())
			System.out.println("Meiji");

		if (calendar.getTimeInMillis() >= TaishoStart.getTimeInMillis()
				&& calendar.getTimeInMillis() <= TaishoEnd.getTimeInMillis())
			System.out.println("Taisho");

		if (calendar.getTimeInMillis() >= ShowaStart.getTimeInMillis()
				&& calendar.getTimeInMillis() <= ShowaEnd.getTimeInMillis())
			System.out.println("Showa");

		if (calendar.getTimeInMillis() >= HeiseiStart.getTimeInMillis()
				&& calendar.getTimeInMillis() <= HeiseiEnd.getTimeInMillis())
			System.out.println("Heisei");

	}
}
