package com.andieguo.android;

public class View {//抽象接口
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
	 * 单击后产生的事件
	 */
	public void click(){
		if(clickListener!=null){
			clickListener.onClick(this);
		}
	}
	/**
	 * 长按后产生的事件
	 */
	public void longClick(){
		if(longClickListener!=null){
			longClickListener.onLongClick(this);
		}
	}
	
	/**
	 * 注册单击监听事件
	 * @param listener
	 */
	public void setOnClickListener(OnClickListener listener){
		this.clickListener = listener;
	}
	
	/**
	 * 注册上按单击事件
	 * @param listener
	 */
	public void setOnLongClickListener(OnLongClickListener listener){
		this.longClickListener = listener;
	}
	
	/**
	 * 内部单击监听接口
	 * @author Administrator
	 *
	 */
	public interface OnClickListener{
		public void onClick(View v);
	}
	
	/**
	 * 内部长按监听接口
	 * @author Administrator
	 *
	 */
	public interface OnLongClickListener{
		public void onLongClick(View v);
	}
	
}
