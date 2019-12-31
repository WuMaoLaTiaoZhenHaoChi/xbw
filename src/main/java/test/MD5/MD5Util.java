package test.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 小霸王
 * @Date: 2019/11/26 14:10
 */
public class MD5Util {

    public static void main(String[] args) {
        String str1 = "duantong123";
        String s1 = encode2hex(str1);

        String str2 = "1";
        String s2 = encode2hex(str2);
        System.out.println(" 加密前 " + str1);
        System.out.println(" 加密后 " + s1);

        System.out.println(" 加密前 " + str2);
        System.out.println(" 加密后 " + s2);
    }

    /**
     * 将源字符串使用MD5加密为字节数组
     * @param source
     * @return
     */
    public static byte[] encode2bytes(String source){
        byte[] result = null;

        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(source.getBytes());
            result = instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将源字符串使用MD5加密为32位16进制数
     * @param source
     * @return
     */
    public static String encode2hex(String source) {
        byte[] data = encode2bytes(source);

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(0xff & data[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }


}
