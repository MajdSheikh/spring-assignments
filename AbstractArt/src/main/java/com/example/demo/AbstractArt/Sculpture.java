package com.example.demo.AbstractArt;


public class Sculpture extends Art {
	private String material;
	public Sculpture(String material) {
		super();
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void viewArt() {
		System.out.println("Info about the art work:" + this.material);
	}
}