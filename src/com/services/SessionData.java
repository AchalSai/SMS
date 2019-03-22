package com.services;

import java.util.ArrayList;
import java.util.List;

public class SessionData {

	private SessionData() {

	}

	private static SessionData sdObj;

	public static synchronized SessionData getSd() {
		if (sdObj == null) {
			return new SessionData();
		}
		return sdObj;
	}

	private List<Integer> listSd = new ArrayList<>();
	
	private List<SessionData> sdList = new ArrayList<>();
	private int choiceCie;
	

	public SessionData(int choiceCie) {
		super();
		this.choiceCie = choiceCie;
	}

	

	public int getChoiceCie() {
		for(int i:listSd) {
			System.out.println("Getting data " + i);
		}
		return choiceCie;
	}

	public void setChoiceCie(int choiceCie) {
		listSd.add(choiceCie);
		System.out.println("Setting data " + choiceCie);
		this.choiceCie = choiceCie;
	}

	public List<SessionData> getChoice() {

		return sdList;
	}

}
