package com.andieguo.button;

import java.util.ArrayList;
import java.util.List;
//一个button按钮对应着多个事件类型。有单击事件，有长按事件。
public class Button {//抽象类
	 private String name = null;    
     private List<ActionListener> actionlisteners = new ArrayList<ActionListener>();
     
     public Button(String name) {
        this.name = name;
     }
     
     public void click(){
         ActionEvent e = new ActionEvent(this.name);
         for(int i=0; i<actionlisteners.size(); i++){
             ActionListener l = actionlisteners.get(i);
             l.actionPerformed(e);
         }
     }
     
     public void addActionListener(ActionListener e){
         actionlisteners.add(e);
     }
}
