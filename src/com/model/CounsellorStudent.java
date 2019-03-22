package com.model;

public class CounsellorStudent {
	private String cid;
	private String sid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "counsellorStudent [cid=" + cid + ", sid=" + sid + "]";
	}
}
