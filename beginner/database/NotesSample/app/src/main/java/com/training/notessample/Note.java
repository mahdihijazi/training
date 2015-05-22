package com.training.notessample;

public class Note {
	public static final String KEY_NOTE_ID = "com.training.notessample.Note.noteId";
	
	private int id;
	private String body;
	
	public Note() {
		
	}
	
	public Note(String body) {
		this.body = body;
		
	}
	
	public Note(int id, String body) {
		this.id = id;
		this.body = body;
		
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public int getId() {
		return this.id;
		
	}
	
	public void setBody(String body) {
		this.body = body;
				
	}
	
	public String getBody() {
		return this.body;
		
	}

}
