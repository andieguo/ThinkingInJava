package com.andieguo.swing;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  
import java.util.*;
public class LayoutFrame extends JFrame implements ActionListener {
    JPanel jp=(JPanel)this.getContentPane();
	private ArrayList<Group> list = new ArrayList<Group>();
	private ArrayList<Integer> listB = new ArrayList<Integer>();
    int y=50;
    int num=0;
    public LayoutFrame()
    {
    	this.setTitle("显示内容");
    	jp.setLayout(null);
    	JButton jb=new JButton("添加行");
    	jb.setBounds(new Rectangle(20,20,80,25));
    	JButton jbadd=new JButton("确定");
    	JButton jbcz=new JButton("重置");
    	jbadd.setBounds(new Rectangle(110,20,80,25));
    	jbcz.setBounds(new Rectangle(200,20,80,25));
    	jp.add(jb);
    	jp.add(jbadd);
    	jp.add(jbcz);
    	jb.addActionListener(this);
    	 
    }
	public static void main(String[] args) { 
       LayoutFrame frame=new LayoutFrame();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
	}
   
	
	public JTextField getMyJTextField(int y) {
		JTextField jt = null;
		jt = new JTextField(20);
		jt.setBounds(new Rectangle(20, y, 100, 20));
		return jt;
	}

	public JTextField getMyJTextField1(int y) {
		JTextField jt1 = null;  
		jt1 = new JTextField(20);
		jt1.setBounds(new Rectangle(130, y, 100, 20));
		return jt1;
	}
	public JButton getMyJButton(int y) {
		JButton jbut=null;
		jbut = new JButton("删除行");
		jbut.setBounds(new Rectangle(240, y, 75, 20)); 
	    return jbut;
	}
	public int getY() {
		return y;
	}
    public void setY(int y) {
		  this.y = y;
	}
    public void advancey() {
		  this.y = this.y + 30;
	}
    public void actionPerformed(ActionEvent arg0) {
		  JButton button = (JButton) arg0.getSource(); 
		  if (button.getText().equals("添加行")) { 
			if(num<20)
			{
			    num++;
			    JTextField jt = null;
			    JTextField jtx = null;
			    JButton jbut = null;
			    if (listB.size() > 0) {
			    Collections.sort(listB);
			    int ny = listB.get(0);
			    jt = getMyJTextField(ny);
			    jtx = getMyJTextField1(ny);
			    jbut = getMyJButton(ny);
			    listB.remove(0);
			   } else {
				this.advancey();
				jt = getMyJTextField(y);
				jtx = getMyJTextField1(y);
				jbut = getMyJButton(y); 
			   }
			   Group gg = new Group();
			   gg.setJb(jbut);
			   gg.setJj(jtx);
			   gg.setJt(jt);
			   list.add(gg);
			   StringBuffer sb = new StringBuffer();
			   this.panelAdd(jp, gg, sb, list, listB);
			   jp.validate();// 重构内容面板
			   jp.repaint();// 重绘内容面板
			} 
		  }
		return;
	}
    public void panelAdd(final JPanel jp, final Group gg,
 		final StringBuffer sb, final ArrayList<Group> ls,
 		final ArrayList<Integer> lt) {
 		jp.add(gg.getJt(), null);
 		jp.add(gg.getJj(), null);
 		jp.add(gg.getJb(), null); 
 		gg.getJb().addActionListener(new ActionListener() {
 		public void actionPerformed(ActionEvent e) {
 		  jp.remove(gg.getJt());
 		  jp.remove(gg.getJj());
 		  jp.remove(gg.getJb());
 		  jp.validate();// 重构内容面板
 		  jp.repaint();// 重绘内容面板
 		  sb.setLength(0);
 		  ls.remove(gg);
 		  lt.add(gg.getJj().getY()); 
 		  num--;
 		 }
 	  });
 	}
}
