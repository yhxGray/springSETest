package com.noXml.test;

public class Car {
	private String cheel;
	private String name;
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	@Override
	public String toString() {
		return "Car [cheel=" + cheel + ", name=" + name + "]";
	}

	public String getCheel() {
		return cheel;
	}

	public void setCheel(String cheel) {
		this.cheel = cheel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car(String cheel, String name) {
		super();
		this.cheel = cheel;
		this.name = name;
	}
	
	public Car(){}
	
}
