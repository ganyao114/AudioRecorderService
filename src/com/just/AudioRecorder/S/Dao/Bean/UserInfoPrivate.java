package com.just.AudioRecorder.S.Dao.Bean;

import java.io.Serializable;

public class UserInfoPrivate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String LoginName;
	private String LoginPassword;
	private String Mail;
	public UserInfoPrivate() {
		// TODO Auto-generated constructor stub
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getLoginPassword() {
		return LoginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
}
