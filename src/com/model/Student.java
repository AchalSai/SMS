package com.model;

public class Student {
private String sname;
private String sid;
private String spassword;
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSpassword() {
	return spassword;
}
public void setSpassword(String spassword) {
	this.spassword = spassword;
}


@Override
public String toString() {
	return "Student [sname=" + sname + ", sid=" + sid + ", spassword=" + spassword + "]";
}




}
