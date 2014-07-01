package com.andieguo.callback.liwang;

public class Wang implements CallBack {
    /** 
     * С���������� 
     * �൱��----->������ 
     */  
    private Li li;   
  
    /** 
     * С���Ĺ��췽��������С������� 
     * @param li 
     */  
    public Wang(Li li){  
        this.li = li;  
    }  
      
    /** 
     * С��ͨ���������ȥ��С������� 
     * @param question  ����С��Ҫ�ʵ�����,1 + 1 = ? 
     */  
    public void askQuestion(final String question){  
    	System.out.println("С���ʵ�����--->" + question);
        //������һ���߳̾����첽��  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                /** 
                 * С������С���еķ�����������ע��ص��ӿ� 
                 * ����൱��A�����B�ķ���C 
                 */  
                li.executeMessage(Wang.this, question);   
            }  
        }).start();  
          
        //С����������ҵ��绰��ȥ�������������ˣ�ڿ��ȥ��  
        play();  
    }  
  
    public void play(){  
        System.out.println("С�����ȥ��");  
    }  
  
	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		System.out.println(result);
	}

}
