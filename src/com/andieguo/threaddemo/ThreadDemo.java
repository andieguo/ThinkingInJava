package com.andieguo.threaddemo;

public class ThreadDemo {

	public class PrintTread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
		
	}
	
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ִ�����߳�1");
				try {
					sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}.start();
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ִ�����߳�2");
				new Thread() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("ִ�����߳�-----1");
						try {
							sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}.start();
				super.run();
			}

		}.start();
		System.out.println("����������");
	}
}
