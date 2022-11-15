package com.example.demo.AbstractArt;

public class Painting extends Art {
	private String paintType;
	public Painting(String paintType) {
		super();
		this.paintType = paintType;
	}
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	public void viewArt() {
		System.out.println("Info about the art work:" + this.paintType);

	}

}