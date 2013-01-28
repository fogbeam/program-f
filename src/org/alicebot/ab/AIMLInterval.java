package org.alicebot.ab;

/**
 * Created with IntelliJ IDEA.
 * User: Richard
 * Date: 1/27/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class AIMLInterval {
    public static int getHoursBetween(final String date1, final String date2){
        final DateTimeFormatter fmt =
                DateTimeFormat
                        .forPattern("HH:mm:ss.SS")
                        .withChronology(
                                LenientChronology.getInstance(
                                        GregorianChronology.getInstance()));
        return Hours.hoursBetween(
                fmt.parseDateTime(date1),
                fmt.parseDateTime(date2)
        ).getHours();
    }
}
