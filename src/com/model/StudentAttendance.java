package com.model;

public class StudentAttendance {
	private String sid;
	private String subname;
	private int classes_attended;
	private int total_classes;
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
	public int getClasses_attended() {
		return classes_attended;
	}
	public void setClasses_attended(int classes_attended) {
		this.classes_attended = classes_attended;
	}
	public int getTotal_classes() {
		return total_classes;
	}
	public void setTotal_classes(int total_classes) {
		this.total_classes = total_classes;
	}
	@Override
	public String toString() {
		return "studentAttendance [sid=" + sid + ", subname=" + subname + ", classes_attended=" + classes_attended
				+ ", total_classes=" + total_classes + "]";
	}
}
