package com.model;

public class ProjectPojo {

	private int sn;
	private String filename;
	private String date;
	
	public ProjectPojo(int sn, String filename, String date) {
		super();
		this.sn = sn;
		this.filename = filename;
		this.date = date;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
