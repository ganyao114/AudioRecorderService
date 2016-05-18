package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;
import java.util.List;

public class AcceptReturnBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3042003336672702209L;
	public String RoomName;
	public String RoomOwner;
	public List<Message> MsgList;
	public List<UserInfoPublic> Guests;
	
	public AcceptReturnBean(String RoomName,String RoomOwner,
			List<Message> MsgList,List<UserInfoPublic> Guests) {
		// TODO Auto-generated constructor stub
		this.RoomName = RoomName;
		this.RoomOwner = RoomOwner;
		this.MsgList = MsgList;
		this.Guests = Guests;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	

	public String getRoomOwner() {
		return RoomOwner;
	}

	public void setRoomOwner(String roomOwner) {
		RoomOwner = roomOwner;
	}

	

	public List<Message> getMsgList() {
		return MsgList;
	}

	public void setMsgList(List<Message> msgList) {
		MsgList = msgList;
	}

	public List<UserInfoPublic> getGuests() {
		return Guests;
	}

	public void setGuests(List<UserInfoPublic> guests) {
		Guests = guests;
	}



}
