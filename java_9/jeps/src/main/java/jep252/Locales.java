package jep252;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Locales {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance(Locale.GERMANY);
        calendar.set(2019, Calendar.MAY, 1);

        DateFormat dayFormatter = new SimpleDateFormat("EEE ", Locale.GERMANY);
        for (int day = 13; day < 20; day++) {
            calendar.set(Calendar.DAY_OF_MONTH, day);
            System.out.print(dayFormatter.format(calendar.getTime()));
        }
        System.out.println();
    }
}
