package experiment.com;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
class Test2{
    public Boolean s1 = null;
}
public class Test1 {

    public static void main(String[] args) {
        /*String city = "北京";
        String CITYZHAOPIN_TITLE = "city招聘_year最新city招聘信息_求职-city拉勾网";
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        CITYZHAOPIN_TITLE = CITYZHAOPIN_TITLE.replace("city", city).replace("year", year);
        System.out.println(CITYZHAOPIN_TITLE);
        
        String CITYPOSITIONZHAOPIN_TITLE = "yearcityposition招聘信息-city拉勾网";
        String position = "Java软件工程师";
        CITYPOSITIONZHAOPIN_TITLE = CITYPOSITIONZHAOPIN_TITLE.replace("year", year).replace("city", city).replace("position", position);
        System.out.println(CITYPOSITIONZHAOPIN_TITLE);*/
        
        /*String regular = "/zhaopin/?|(/zhaopin/\\d+/?)";
        
        String servletPath = "/zhaopin/1/";
        String pageNum = getPageNumInServletPath(servletPath);
        System.err.println(pageNum);*/
        /*
        String[] arrs = getPageInfoInServletPath("/zhaopin/", "");
        System.out.println(arrs);*/
        
        /*try {
            System.out.println(URLEncoder.encode("/asdfasdf/C++/", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }
    

    
    /**
     * 从servletPath中查找可能的1)分页码，2)返回不带分页码的URL，以及3)职位；
     * <br>
     * @param servletPath
     * @param regular /zhaopin/([.[^/]]*)/?|/zhaopin/([.[^/]]*)/(\d+)/?
     * @return String[3]。
     * <ul>
     * <li>[0]分页码数字，返回1当servletPath为blank或没有找到分页码时。</li>
     * <li>[1]不带分页码的URL，以"/"结尾，返回""当servletPath为blank。</li>
     * <li>[2]职位拼音，返回""当servletPath为blank。</li>
     * </ul>
     */
    private static String[] getPageInfoInServletPath(String servletPath, String regular){
        regular = "/zhaopin/([.[^/]]*)/?|/zhaopin/([.[^/]]*)/(\\d+)/?";
        String[] arrs = new String[3];
        arrs[0] = "1";
        arrs[1] = "";
        arrs[2] = "";
        if (StringUtils.isBlank(servletPath)) {
            return arrs;
        }
        
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(servletPath);
        if (matcher.find()) {
            // 职位拼音，组1和组2只有一个能捕获成功
            String positionPinYinG1 = matcher.group(1);
            String positionPinYinG2 = matcher.group(2);
            if (positionPinYinG1 != null) {
                arrs[2] = positionPinYinG1;
            }else if (positionPinYinG2 != null) {
                arrs[2] = positionPinYinG2;
            }
            // 不带页码的URL
            StringBuilder seoBaseUrl = new StringBuilder("/zhaopin/");
            seoBaseUrl.append(arrs[2]).append("/");
            arrs[1] = seoBaseUrl.toString();
            // 如果有页码
            if (matcher.group(3) != null) {
                arrs[0] = matcher.group(3);
            }
        }
        return arrs;
    }
    
    /**
     * 从servletPath中查找可能的分页码。
     * @param servletPath
     * @return 返回分页码数字，或者返回null当servletPath为blank或没有找到分页码时。
     */
    public static String getPageNumInServletPath(String servletPath){
        if (StringUtils.isBlank(servletPath)) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(servletPath);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
    
    /**
     * 从serlvetPath中获取关键字
     * @author Oliver
     * @param content 数据源
     * @param regex 正则
     * @param groupCount 正则中包含的group数目
     * @return 匹配上的信息，数组长度等于groupCount
     */
    public static String[] getMatchInfo(String content, String regex, int groupCount) {
        if(groupCount <= 0){
            groupCount = 1;
        }
        String[] keyInfos = new String[groupCount];
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            for (int i = 0; i < groupCount; i++) {
                keyInfos[i] = matcher.group(i+1);//group从1开始
            }
        }
        return keyInfos;
    }

}
