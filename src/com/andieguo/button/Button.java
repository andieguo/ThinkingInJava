package com.andieguo.button;

import java.util.ArrayList;
import java.util.List;
//һ��button��ť��Ӧ�Ŷ���¼����͡��е����¼����г����¼���
public class Button {//������
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
