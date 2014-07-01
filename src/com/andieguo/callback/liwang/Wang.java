package com.andieguo.callback.liwang;

public class Wang implements CallBack {
    /** 
     * 小李对象的引用 
     * 相当于----->背景二 
     */  
    private Li li;   
  
    /** 
     * 小王的构造方法，持有小李的引用 
     * @param li 
     */  
    public Wang(Li li){  
        this.li = li;  
    }  
      
    /** 
     * 小王通过这个方法去问小李的问题 
     * @param question  就是小王要问的问题,1 + 1 = ? 
     */  
    public void askQuestion(final String question){  
    	System.out.println("小王问的问题--->" + question);
        //这里用一个线程就是异步，  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                /** 
                 * 小王调用小李中的方法，在这里注册回调接口 
                 * 这就相当于A类调用B的方法C 
                 */  
                li.executeMessage(Wang.this, question);   
            }  
        }).start();  
          
        //小网问完问题挂掉电话就去干其他的事情了，诳街去了  
        play();  
    }  
  
    public void play(){  
        System.out.println("小王逛街去了");  
    }  
  
	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		System.out.println(result);
	}

}
