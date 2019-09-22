package com.noteIt.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {

	@Id
	private UUID id;
	private String title;
	private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	private Notebook notebook;
	
	private Date lastModifiedOn;
	
	public Note(){
		this.id = UUID.randomUUID();
		this.lastModifiedOn = new Date();
	}

	public Note(String title, String text, Notebook notebook) {
		super();
		this.title = title;
		this.text = text;
		this.notebook = notebook;
	}
	
	public Note(String id, String title, String text, Notebook notebook){
		this(title,text,notebook);
		if(id!= null){
			this.id = UUID.fromString(id);
		}
	}
	
	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public String getNotebookId() {
		return this.notebook.getId().toString();
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	
}
