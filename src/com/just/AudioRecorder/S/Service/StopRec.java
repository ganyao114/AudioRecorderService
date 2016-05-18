package com.just.AudioRecorder.S.Service;

import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;

public class StopRec {
	public static boolean Stop(String LoginName, String RoomName) {
		RoomBean roomBean = StaticDataPackage.Rooms.get(RoomName);
		if (roomBean.RoomOwner.userName.equals(LoginName)) {
			for (User user : roomBean.RoomMenber) {

				user.getRequestBean().stoped = "stoped";
				//roomBean.RoomMenber.remove(user);
				user.room = null;

			}
			SendEmailThread sendEmailThread = new SendEmailThread(roomBean);
			new Thread(sendEmailThread).start();
			StaticDataPackage.Rooms.remove(RoomName);
		} else {
			for (User user : roomBean.RoomMenber) {
				if (user.userName.equals(LoginName)) {
					roomBean.RoomMenber.remove(user);
					user.room = null;
				}
			}
		}
		return true;

	}
}
