package com.andieguo.callback.liwang;

public class Li {
	/**
	 * �൱��B���в���ΪCallBack callBack��f()---->������
	 * 
	 * @param callBack
	 * @param question
	 *            С���ʵ�����
	 */
	public void executeMessage(CallBack callBack, String question) {
		

		// ģ��С����Լ���������Ҫ�ܳ�ʱ��
		for (int i = 0; i < 2; i++) {
			System.out.println("С����æ");
		}
		/**
		 * С������Լ�������֮���뵽�˴���2
		 */
		String result = "С����Ĵ���2";

		/**
		 * ���Ǿʹ�绰����С��������С���еķ��� ����൱��B�෴��������A�ķ���D
		 */
		callBack.solve(result);

	}
}
