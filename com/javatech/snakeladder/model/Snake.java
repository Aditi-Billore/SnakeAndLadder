package com.javatech.snakeladder.model;

public class Snake {
	private int beginPosition;
	private int endPosition;
	
	
	public Snake(int beginPosition, int endPosition) {
		this.beginPosition = beginPosition;
		this.endPosition = endPosition;
	}
	public int getBeginPosition() {
		return beginPosition;
	}
	public int getEndPosition() {
		return endPosition;
	}
}
