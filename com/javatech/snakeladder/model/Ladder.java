package com.javatech.snakeladder.model;

public class Ladder {
	private int beginPosition;
	private int endPosition;
	
	
	public Ladder(int beginPosition, int endPosition) {
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
