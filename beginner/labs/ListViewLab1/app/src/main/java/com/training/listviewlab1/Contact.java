package com.training.listviewlab1;

public class Contact {
	public String name;
	public int pictureId;

	public Contact(String name, int pictureId) {
		this.name = name;
		this.pictureId = pictureId;
		
	}
	
	@Override
	public String toString() {
		return name;
	}
}
