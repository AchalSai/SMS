package com.model;

public class Subject {
	
	private String subid;
	private String subname;
	private int total_marks;

	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public int getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	@Override
	public String toString() {
		return "subject [subid=" + subid + ", subname=" + subname + ", total_marks=" + total_marks + "]";
	}

}
