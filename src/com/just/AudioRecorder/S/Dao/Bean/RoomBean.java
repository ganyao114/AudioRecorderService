package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class RoomBean implements Serializable {

    public User RoomOwner;
    public String RoomName;
    public Vector<User> RoomMenber;
    public Vector<Message> Message;
    
    public RoomBean() {
		// TODO Auto-generated constructor stub
    	this.RoomMenber = new Vector<User>();
    	this.Message = new Vector<Message>();
	}
    
    public List<Message> getMessage() {
        return Message;
    }

    public void setMessage(Vector<Message> Message) {
        this.Message = Message;
    }

 

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }

  
    
    public String AcceptRequestGuests;

    public String getAcceptRequestGuests() {
        return AcceptRequestGuests;
    }

    public void setAcceptRequestGuests(String AcceptRequestGuests) {
        this.AcceptRequestGuests = AcceptRequestGuests;
    }
    private static final long serialVersionUID = 6900939382645825277L;
	public User getRoomOwner() {
		return RoomOwner;
	}

	public void setRoomOwner(User roomOwner) {
		RoomOwner = roomOwner;
	}

	public List<User> getRoomMenber() {
		return RoomMenber;
	}

	public void setRoomMenber(Vector<User> roomMenber) {
		RoomMenber = roomMenber;
	}



}

