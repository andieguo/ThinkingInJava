package com.andieguo.util;

public class IntegerDemo {
	public static void change(byte[] data){
		data = new byte[]{0x01,0x02};
		for(int i=0;i<2;i++){
			System.out.println(data[i]);
		}
	}
	
	public static int i[] = new int[4];

	public void ParameterTest(int j[]) {//ͨ���βθı�ʵ�ε�ֵ
		int k = 0;
		while (k < j.length) {
			j[k] = k;
			System.out.println("�β�����j[" + k + "]=" + j[k]);
			System.out.println("ʵ������i[" + k + "]=" + i[k]);
			k = k + 1;
		}
	}
	
	public static void main(String[] args) {
		
		//System.out.println(Integer.parseInt("FF", 16));// ��16���ơ�FF��ת��Ϊint������:255
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
	 * ����У��
	 */
	public static byte CRC(byte[] frame,int datalength){
		byte data=0;
		for(int i=0;i<datalength;i++){
			data ^=frame[i];
		}
		return data;
	}
	

	public static void hex(){
		//��16�����ַ���ת��ΪInteger��
		Integer i = Integer.parseInt("FFFFFFF", 16);
		System.out.println(i);
		//��Integer��ת��Ϊ16�����ַ���
		String hexStr2=Integer.toHexString(268435455);
		System.out.println(hexStr2);
	}
	
	
	
}
