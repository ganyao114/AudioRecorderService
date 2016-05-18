package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userName;
    public String password;
    public String email;
    public RoomBean room;
    public RequestBean requestBean;
    public User(String userName,String password,String email){
    	this.userName = userName;
    	this.password = password;
    	this.email = email;
    	requestBean = new RequestBean(null, null, null, null);
    	
    }
    public String getUserName()
    {
        return userName;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEamil()
    {
        return email;
    }
	public RoomBean getRoom() {
		return room;
	}
	public void setRoom(RoomBean room) {
		this.room = room;
	}
	public  RequestBean getRequestBean() {
		return requestBean;
	}
	public  void setRequestBean(RequestBean requestBean) {
		this.requestBean = requestBean;
	}
	public String getEmail() {
		return email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

