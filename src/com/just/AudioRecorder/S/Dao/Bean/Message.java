package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3954618566652076086L;
	
	
	public String Sender;
	public String Content;
	public String Data;
	public String Receiver;
	
	public Message(String Sender,String Content,String Data,
			String Receiver) {
		// TODO Auto-generated constructor stub
		this.Sender = Sender;
		this.Content = Content;
		this.Data = Data;
		this.Receiver = Receiver;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getReceiver() {
		return Receiver;
	}

	public void setReceiver(String receiver) {
		Receiver = receiver;
	}

}
