package com.skildust.ServerGreeter;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static long getTimestampYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); // get yesterday

        // set to midnight
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date yesterday = cal.getTime();

        return yesterday.getTime();
    }
}
