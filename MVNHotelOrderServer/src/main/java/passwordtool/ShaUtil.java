package passwordtool;

import java.security.MessageDigest;

/**
 * 
 * @author wshwbluebird
 *
 */
public class ShaUtil {
	/**
	 * 
	 * @param str
	 * @return 40 bits shaPassword
	 * @throws Exception
	 */
	public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) { 
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
	
	 public static void main(String[] args) throws Exception {
//			ShaUtil sha = new ShaUtil();
//			System.out.println(sha.shaEncode("1231231231231231233243232432"));
//			System.out.println(sha.shaEncode("1234"));
//			System.out.println(sha.shaEncode("12345").length());
		}
}
