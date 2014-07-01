package com.andieguo.button;

public class MainTest {
	//内部类的问题
	public static void main(String args[]) {
		test1();
	}

	public static void test0(){
		MainTest mainTest = new MainTest();
		BtnActionListener btnActionListener = mainTest.new BtnActionListener();
		Button button0 = new Button("按钮0");
		Button button1 = new Button("按钮1");
		Button button2 = new Button("按钮2");
		Button button3 = new Button("按钮3");
		Button button4 = new Button("按钮4");
		button0.addActionListener(btnActionListener);
		button1.addActionListener(btnActionListener);
		button2.addActionListener(btnActionListener);
		button3.addActionListener(btnActionListener);
		button4.addActionListener(btnActionListener);
		button0.click();
		button1.click();
		button2.click();
		button3.click();
		button4.click();
	}
	
	
	public static void test1() {
		Button button = new Button("按钮");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("监听事件1"+e.getName());
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("监听事件2"+e.getName());
			}
		});
		button.click();
	}
	
	public class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getName());
		}
		
	}
}
