package experiment.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class RegularTest1 {

    public static void main(String[] args) {
        /*String a[] = getInfoInServletPath("/hangzhou/", "/beijing/?|/shanghai/?|/hangzhou/?|/guangzhou/?|/shenzhen/?|/chengdu/?");
        System.out.println("==" + a[0]);*/
        
        /*int i1 = 30 % 15;
        System.out.println(i1);*/
    }
    
    /**
     * 从servletPath中查找可能的1) 城市拼音；
     * @param servletPath
     * @return String[1]。
     * <ul>
     * <li>[0]城市拼音，返回""当servletPath为blank或没有找到城市时。</li>
     * </ul>
     */
    private static String[] getInfoInServletPath(String servletPath, String regular){
        String[] arrs = new String[1];
        arrs[0] = "";
        if (StringUtils.isBlank(servletPath)) {
            return arrs;
        }
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(servletPath);
        if (matcher.find()) {
            String s = matcher.group();
            if (s.endsWith("/")) {//如果是这样：/shanghai/，就掐头去尾
                arrs[0] = s.substring(1, s.length() - 1);
            }else {//否则：/shanghai，只掐头
                arrs[0] = s.substring(1, s.length());
            }
        }
        return arrs;
    }

}
