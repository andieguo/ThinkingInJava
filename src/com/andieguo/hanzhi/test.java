package com.andieguo.hanzhi;

public class test {

	static void byteToString(){
		byte[] temp = new byte[]{(byte) 0xB6,(byte) 0xF5,0x41,0x38,0x38,0x38,0x38,0x38};
		String str = new String(temp);
		temp = str.getBytes();
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]&0xff);
		}
	}
	
	public static void main(String[] args) {
		// 十六进制转成十进制
//		 System.out.println(Integer.toHexString(10000));
//		 System.out.println(Integer.parseInt("2710",16));

		byte[] b = stringToByte2("鄂A88888");
		System.out.println(byteToString2(b));

	}

	public static void stringToByte() {
	
		String temp = "鄂A88888";
		byte[] b = temp.getBytes();
		byte[] result = new byte[b.length];
		String str = "";
		for (int i = 0; i < b.length; i++) {
			Integer I = new Integer(b[i]);
			String strTmp = I.toHexString(b[i]);
			if (strTmp.length() > 2)
				strTmp = strTmp.substring(strTmp.length() - 2);
			System.out.print(result[i]+" ");
			str = str + strTmp;
		}
		System.out.println(str.toUpperCase());
	}
	public static byte[] stringToByte2(String str) {
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.println(""+String.format("%02x", b[i]));
		}
		return b;
	}
	
	public static String byteToString2(byte[] b){
		String str = new String(b);
		return str;
	}
}
