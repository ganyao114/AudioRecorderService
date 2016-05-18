package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;
import java.util.Vector;



public class RequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7937271580880710206L;
	public Vector<Message> Msgs;
	public getRequest request;
	public String stoped;
	public Vector<UserInfoPublic> Guests;
	
	public RequestBean(Vector<Message> Msgs,getRequest request,
			 String stoped,Vector<UserInfoPublic> Guests) {
		// TODO Auto-generated constructor stub
		Msgs = new Vector<Message>();
		Guests = new Vector<UserInfoPublic>();
		this.Msgs = Msgs;
		this.request = request;
		this.stoped = stoped;
		this.Guests = Guests;
		
	}

	public Vector<Message> getMsgs() {
		return Msgs;
	}

	public void setMsgs(Vector<Message> msgs) {
		Msgs = msgs;
	}

	public getRequest getRequest() {
		return request;
	}

	public void setRequest(getRequest request) {
		this.request = request;
	}

	public String getStoped() {
		return stoped;
	}

	public void setStoped(String stoped) {
		this.stoped = stoped;
	}

	public Vector<UserInfoPublic> getGuests() {
		return Guests;
	}

	public void setGuests(Vector<UserInfoPublic> guests) {
		Guests = guests;
	}


	
}
