package passwordtool;

import java.security.MessageDigest;

/**
 * 
 * @author wshwbluebird
 *
 */
public class MD5Util {
	/**
	 * 
	 * @param str
	 * @return 32bit md5password
	 * @throws Exception
	 */
	 public  String md5Encode(String inStr) throws Exception {
	        MessageDigest md5 = null;
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (Exception e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	            return "";
	        }

	        byte[] byteArray = inStr.getBytes("UTF-8");
	        byte[] md5Bytes = md5.digest(byteArray);
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
		MD5Util md = new MD5Util();
		System.out.println(md.md5Encode("1231231231231231233243232432"));
		System.out.println(md.md5Encode("1234"));
		System.out.println(md.md5Encode("12345").length());
	}
}
