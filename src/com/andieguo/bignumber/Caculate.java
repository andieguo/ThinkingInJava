package com.andieguo.bignumber;

public interface Caculate {
	/**
	 * ���������������
	 * @param first
	 * @param second
	 * @return �õ��Ľ�����ַ�����ʾ
	 */
	abstract String multiply(String first, String second) ;
	/**
	 * ���������������
	 * @param first
	 * @param second 
	 * @return �õ��Ľ�����ַ�����ʾ
	 */
	abstract  String add(String first, String second);
	/**
	 * ���������������
	 * @param first
	 * @param second
	 * @return �õ��Ľ�����ַ�����ʾ
	 */
	abstract  String reduce(String first, String second);
	/**
	 * ��������������˲����������
	 * @param numberOne
	 * @param numberTwo
	 * @return �õ��Ľ�����ַ����鴢��
	 */
	abstract String[] divide(final String numberOne,final  String numberTwo);

}
