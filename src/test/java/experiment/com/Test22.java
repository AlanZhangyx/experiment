package experiment.com;

import java.io.UnsupportedEncodingException;

public class Test22 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char c = '伟';
        String s = "伟";
        int i = (int) c;
        System.out.println(i);

        byte[] bs = s.getBytes("UTF-16BE");
       /* int heigh = ((int) bs[0]) << 8;
        int low = ((int) bs[1]);
        int i2 = heigh + low;
        System.out.println(i2);*/
        
        int bytePadding = 0xff;
        /*int heigh = (int)(intPadding & bs[0]) << 8;
        int low = (int)intPadding & bs[1];
        int i2 = heigh & low;
        System.out.println(i2);*/
        
        int heigh = (bs[0] & bytePadding) << 8;  
        int low = bs[1] & bytePadding;
        int result = heigh | low;
        System.out.println(result);
        
        
        /*int heigh = (bs[0] & bytePadding) << 16;  
        int middle = (bs[1] & bytePadding) << 8;
        int low = bs[2] & bytePadding;
        int result = heigh | middle | low;
        System.out.println(result);*/
        
    }
}
