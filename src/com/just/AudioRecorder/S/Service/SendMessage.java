package com.just.AudioRecorder.S.Service;

import com.just.AudioRecorder.S.Dao.Bean.Message;
import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;

public class SendMessage {
	public SendMessage() {
		// TODO Auto-generated constructor stub
	}

	public static void Send(String LoginName, Message msg) {
		RoomBean roomBean = StaticDataPackage.UserSOnline.get(LoginName)
				.getRoom();
		roomBean.Message.add(msg);
		for (User user : roomBean.getRoomMenber()) {

			user.getRequestBean().Msgs.add(msg);

		}
	}
}
