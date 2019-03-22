package com.model;

public class StudentMarks {
	private String sid;
	private String subname;
	private int marks_obtained;
	private int total_marks;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(int marks_obtained) {
		this.marks_obtained = marks_obtained;
	}

	public int getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}

	@Override
	public String toString() {
		return "StudentMarks [sid=" + sid + ", subname=" + subname + ", marks_obtained=" + marks_obtained
				+ ", total_marks=" + total_marks + "]";
	}
}