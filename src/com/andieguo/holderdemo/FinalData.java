package com.andieguo.holderdemo;

public class FinalData {
	private final int valueOne = 3;
	private int valueTwo = 4;
	private final Value v1 = new Value(4);
	private Value v2 = new Value(10);
	private final int[] a = {1,2,3,4,5,6,7,8,9};
	private int[] b = {1,2,3,4,5,6,7,8,9};
	private static final int VAL_TWO = 3;
	
	public static void main(String[] args) {
		FinalData finalData = new FinalData();
		/*-----------�������Ͳ���------------------------------------*/
//		finalData.valueOne = 4;//valueOne�ǳ������޷��޸�
		finalData.valueTwo = 14;//valueTwo���ǳ����������޸�
		
		/*-----------�������Ͳ���------------------------------------*/
//		finalData.v1 = new Value(5);//v1������final�ͳ��������������޷��޸ĵġ�
		finalData.v2 = new Value(20);//v2����final�ͳ����������ÿ����޸ġ�
		finalData.v1.i = 5;//v1����ĳ�Ա��������final�ͣ������޸�
		
		/*-----------�������Ͳ���------------------------------------*/
//		finalData.a = new int[3];//����a��final�ͣ��޷��޸�a������
		finalData.b = new int[13];//����b����final�ͣ����Զ������ý����޸�
		for(int i=0;i<finalData.a.length;i++) 
			finalData.a[i]++;//����a�ڲ�������int�ͣ�����final�ͣ������޸�
		
		/*-----------static final���Ͳ���------------------------------------*/
//		finalData.VAL_TWO = 4;
		//����Ϊprivate��ֻ�ܱ�����ķ������ã�����Ϊstatic����ǿ��ֻ��һ�ݣ���ֻ��ִ��һ�Σ�����Ϊfinal����˵������һ���������޷����޸ġ�
		
	}
}
