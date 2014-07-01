package com.andieguo.android;

public class EditText extends View {
	private String text = null;
	public EditText(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
}
