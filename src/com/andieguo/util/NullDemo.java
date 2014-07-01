package com.andieguo.util;

/**
 * Java ���ַ�����Null������
 * 1��String str = "";˵��str��һ�����ַ����������ڴ����Ǵ��ڵģ��������ڴ�ռ�.������ʹ��Object�����еķ���(��"".toString();"".equals())��
 * 	 String str = null;// null��ʾû�з����ڴ�ռ䣬���ڴ����ǲ����ڵģ�û�з����ڴ�ռ�.��������ʹ��Object�����еķ���(��"".toString();"".equals())��ʹ�ú�ᱨ��java.lang.NullPointerException
 * 2 ������equals�Ƚϣ�null�õȺűȽ�;
 * @author Administrator
 *
 */
/**
 * Java���ַ�����null����
 * 
 * 1������ null��ʾ����һ�������ֵ����������һ���ַ�������������һ����������ã�String a = null ;
 * ""��ʾ����һ�����ַ�����Ҳ����˵���ĳ���Ϊ0����������һ���ַ���String str = "" ;
 * 
 * 2���ڴ���� String str = null ; ��ʾ����һ���ַ�����������ã���ָ��Ϊnull��Ҳ����˵��û��ָ���κε��ڴ�ռ䣻 String
 * str = ""; ��ʾ����һ���ַ������͵����ã���ֵΪ""���ַ��������str����ָ����ǿ��ַ������ڴ�ռ䣻
 * 
 * ��java�б��������ñ����Ǵ���ջ�У�stack����������new�����ģ����Ǵ���ڶ��У�heap����
 * 
 * �����£�
 * 
 * String str = new String("abc") ;
 * 
 * ps��=��ߵ��Ǵ����ջ�У�stack����=�ұ��Ǵ���ڶ��У�heap����
 * 
 * @author Administrator
 * 
 */
public class NullDemo {
	/**
	 * ����Java�����������Ƚ���ȵķ���һ�����á�==������һ����String �����equals()�����������������ǣ�ǰ�߱Ƚϵ��ǵ�ַ�����߱Ƚϵ�
	 * �����ݡ�
	 * 
	 * ������д��������һ����� String str1��str2�� �Ǿ��Ƕ���������ָ��ͬStringʵ���ľ�����������Ƕ���ָ��null
	 * ������str1==str2==null����ʱ�㲻����length()��������Ϊ������ ��û��ָ�����Ķ������������������Ļ����᷵��һ��
	 * NullPointerException�� ֮�������д����������� str1=new String();
	 * ��ôstr1��ָ��һ�������Stringʵ��������str1!=str2,str1!=null��
	 * ���Ҹ���Ҫ����str1��=""����Ϊ""��str1��ָ����������ͬ�ĵ�ַ�� ������str1.length()�ķ���ֵ����0�ˣ�Ҳ�����ַ���Ϊ�ա�
	 * ͬ����ʹ��������д str2=new String(); ���ʱ����Ȼ��str1��=str2����Ϊ����ָ�����������ͬ�ĵ�ַ��
	 * ���������str1.equals(str2)�Ļ�������ֵ����true����Ϊ���ǵ��� ����ͬ����Ϊ�ա�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		String str = new String();// Ĭ���ǿմ�
		if (str.equals("")) {
			System.out.println("Ĭ���ǿմ�");
		}
	}

	public static void test2() {

		// ""��һ���ַ���(String).�����ڴ����Ǵ��ڵ�.������ʹ��Object�����еķ���(��"".toString();"".equals())
		String str1 = "";// ""�������ڴ� �ռ䣬��ʾ����һ���ַ������͵����ã���ֵΪ""���ַ��������str����ָ����ǿ��ַ������ڴ�ռ䣻

		// ��null����һ���ն���.���ڴ����ǲ����ڵ�.��������ʹ��Object�����еķ���
		String str = null;// null��ʾû�з����ڴ�ռ�
		
		System.out.println(str1.equals(""));// ������equals�Ƚϣ�null�õȺűȽ�
		System.out.println(str == null);// ������equals�Ƚϣ�null�õȺűȽ�
		
		System.out.println(str.equals(null));//����null���ַ����ķ������׿�ָ��java.lang.NullPointerException�쳣��

		if (str != null &&!(str.length() > 0)) { // ���ж��ǲ��Ƕ�������ǣ����ж��ǲ��ǿ��ַ���
			// do something
		}
		
		if (str != null && !str.equals("")){
			// do something
		}
	}
}
