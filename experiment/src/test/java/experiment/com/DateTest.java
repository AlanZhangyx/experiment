package experiment.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateTest {
    
    /**
     * 时间格式yyyy-MM-dd HH:mm:ss
     */
    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * 当前线程处理日期；
     * <br>
     * 从2016-01-01 00:00:00（包含） 开始
     */
    private static Date currentProcessDate = null;
    
    /**
     * 到2016-08-29 00:00:00（包含） 结束
     */
    private static final Date LIMIT_DATE;
    private static Calendar calendar = Calendar.getInstance();
    static{
        // 设置结束日期为2016-01-05 00:00:00
        calendar.set(2016, 0, 5, 0, 0, 0);
        LIMIT_DATE = calendar.getTime();
        
        // 设置开始日期为2016-01-01 00:00:00
        calendar.set(2016, 0, 1, 0, 0, 0);
        currentProcessDate = calendar.getTime();
    }
    /**
     * 用3个线程去跑
     */
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        DateTest dt = new DateTest();
        // 循环执行
        while (currentProcessDate.before(LIMIT_DATE)) {
            dt.process();
        }
    }
    
    public void process(){
        fixedThreadPool.execute(new Thread() {
            @Override
            public void run() {
                Date startDate = null;
                Date endDate = null;
                synchronized (calendar) {
                    // 开始时间：是当前线程的处理日期
                    startDate = currentProcessDate;
                    // 计算结束时间：+1天再减1秒
                    calendar.add(Calendar.DATE, 1);
                    currentProcessDate = calendar.getTime();// 设置下个线程处理的日期
                    calendar.add(Calendar.SECOND, -1);
                    endDate = calendar.getTime();
                    calendar.add(Calendar.SECOND, 1);//复原calendar的时间
                }
                System.out.println(Thread.currentThread().getName() + "zzzz" + DF.format(startDate) + "----" + DF.format(endDate));
            }
        });
    }
}
