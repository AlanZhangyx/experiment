package experiment.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest2 {

    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 0, 1, 0, 0, 0);
//        calendar.set(2016, 7, 29, 0, 0, 0);
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.SECOND, -1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(calendar.getTime()));
        System.out.println(df.format(new Date()));
    }

}
