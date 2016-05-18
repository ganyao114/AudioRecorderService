package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;

public class getRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847342545942840509L;
	public String Sender;
	public String RoomName;
	
	public getRequest(String Sender,String RoomName) {
		// TODO Auto-generated constructor stub
		this.Sender = Sender;
		this.RoomName = RoomName;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

}

