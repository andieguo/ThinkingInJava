package com.andieguo.android;

public class View {//����ӿ�
	private String name = null;
	
	public View(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private OnClickListener clickListener = null;
	private OnLongClickListener longClickListener = null;

	/**
	 * ������������¼�
	 */
	public void click(){
		if(clickListener!=null){
			clickListener.onClick(this);
		}
	}
	/**
	 * ������������¼�
	 */
	public void longClick(){
		if(longClickListener!=null){
			longClickListener.onLongClick(this);
		}
	}
	
	/**
	 * ע�ᵥ�������¼�
	 * @param listener
	 */
	public void setOnClickListener(OnClickListener listener){
		this.clickListener = listener;
	}
	
	/**
	 * ע���ϰ������¼�
	 * @param listener
	 */
	public void setOnLongClickListener(OnLongClickListener listener){
		this.longClickListener = listener;
	}
	
	/**
	 * �ڲ����������ӿ�
	 * @author Administrator
	 *
	 */
	public interface OnClickListener{
		public void onClick(View v);
	}
	
	/**
	 * �ڲ����������ӿ�
	 * @author Administrator
	 *
	 */
	public interface OnLongClickListener{
		public void onLongClick(View v);
	}
	
}
