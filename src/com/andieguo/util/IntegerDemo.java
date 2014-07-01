package com.andieguo.util;

public class IntegerDemo {
	public static void change(byte[] data){
		data = new byte[]{0x01,0x02};
		for(int i=0;i<2;i++){
			System.out.println(data[i]);
		}
	}
	
	public static int i[] = new int[4];

	public void ParameterTest(int j[]) {//通过形参改变实参的值
		int k = 0;
		while (k < j.length) {
			j[k] = k;
			System.out.println("形参数组j[" + k + "]=" + j[k]);
			System.out.println("实参数组i[" + k + "]=" + i[k]);
			k = k + 1;
		}
	}
	
	public static void main(String[] args) {
		
		//System.out.println(Integer.parseInt("FF", 16));// 将16进制“FF”转换为int型数据:255
//		byte[] data = new byte[]{0x02,0x00,0x55,0x39,(byte)0xC9,(byte)0xA7};
//		byte result = CRC(data,5);
//		System.out.println(String.format("%02X ", result));
		
//		byte[] buffer = new byte[2];
//		buffer[0] = 0x03;
//		change(buffer);
		
//		for(int i=0;i<2;i++){
//			System.out.println(buffer[i]);
//		}
		
	//	new IntegerDemo().ParameterTest(i);
		hex();
	}
	
	/*
	 * 数据校验
	 */
	public static byte CRC(byte[] frame,int datalength){
		byte data=0;
		for(int i=0;i<datalength;i++){
			data ^=frame[i];
		}
		return data;
	}
	

	public static void hex(){
		//将16进制字符串转换为Integer型
		Integer i = Integer.parseInt("FFFFFFF", 16);
		System.out.println(i);
		//将Integer型转换为16进制字符串
		String hexStr2=Integer.toHexString(268435455);
		System.out.println(hexStr2);
	}
	
	
	
}
