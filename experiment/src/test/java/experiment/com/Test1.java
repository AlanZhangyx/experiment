package experiment.com;

import java.util.Calendar;

public class Test1 {

    public static void main(String[] args) {
        String city = "北京";
        String CITYZHAOPIN_TITLE = "city招聘_year最新city招聘信息_求职-city拉勾网";
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        CITYZHAOPIN_TITLE = CITYZHAOPIN_TITLE.replace("city", city).replace("year", year);
        System.out.println(CITYZHAOPIN_TITLE);
        
        String CITYPOSITIONZHAOPIN_TITLE = "yearcityposition招聘信息-city拉勾网";
        String position = "Java软件工程师";
        CITYPOSITIONZHAOPIN_TITLE = CITYPOSITIONZHAOPIN_TITLE.replace("year", year).replace("city", city).replace("position", position);
        System.out.println(CITYPOSITIONZHAOPIN_TITLE);
    }

}
