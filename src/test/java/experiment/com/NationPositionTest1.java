package experiment.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class NationPositionTest1 {
    
    public static void main(String[] args) {
        String regular = "/zhaopin/([.[^/]]*)/?|/zhaopin/([.[^/]]*)/(\\d+)/?";
        getPageInfoInServletPath("/zhaopin/PHP/3", regular);
    }
    
    /**
     * 从servletPath中查找可能的1)分页码，2)返回不带分页码的URL，以及3)职位；
     * <br>
     * @param servletPath
     * @param regular /zhaopin/([.&&[^/]]*)/?|/zhaopin/([.&&[^/]]*)/(\d+)/?
     * @return String[3]。
     * <ul>
     * <li>[0]分页码数字，返回1当servletPath为blank或没有找到分页码时。</li>
     * <li>[1]不带分页码的URL，以"/"结尾，返回""当servletPath为blank。</li>
     * <li>[2]职位拼音，返回""当servletPath为blank。</li>
     * </ul>
     */
    private static String[] getPageInfoInServletPath(String servletPath, String regular){
        String[] arrs = new String[3];
        arrs[0] = "1";
        arrs[1] = "";
        arrs[2] = "";
        if (StringUtils.isBlank(servletPath)) {
            return arrs;
        }
        
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(servletPath);
        if (matcher.matches()) {
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

}
