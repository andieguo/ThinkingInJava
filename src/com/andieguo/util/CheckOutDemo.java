package com.andieguo.util;

public class CheckOutDemo {

	public static void main(String[] args) {
		yihuo();
	}
	/**
	 * 异或校验和
	 */
	public static void yihuo() {
		byte[] datas = new byte[] { 0x0D, 0x0D, 0x10, (byte) 0xFF, (byte) 0xFF,
				(byte) 0xFF, 0x46, 0x10, 0x00, 0x00, 0x00, 0x00, 0x06, 0x19,
				(byte) 0x81 };
		byte sum = 0x00;
		for(int i=0;i<datas.length;i++){
			sum^=datas[i];
		}
		System.out.println(sum&0xff);
	}
}
