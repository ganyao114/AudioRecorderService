package com.just.AudioRecorder.S.Service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.getRequest;

public class CreateRoomService {

	private String LoginName;
	private String RoomName;
	private List<User> guestlists;

	public CreateRoomService(String LoginName, String RoomName,
			JSONArray GuestList) {
		// TODO Auto-generated constructor stub
		this.LoginName = LoginName;
		this.RoomName = RoomName;
		this.guestlists = AnalyzJson(GuestList);
	}

	public boolean doCrateRoom() {
		if (StaticDataPackage.Rooms.get(RoomName) != null) {
			return false;
		} else {
			RoomBean roomBean = new RoomBean();
			roomBean.RoomOwner = StaticDataPackage.UserSOnline.get(LoginName);
			roomBean.RoomMenber.add(StaticDataPackage.UserSOnline
					.get(LoginName));
			StaticDataPackage.UserSOnline.get(LoginName).room = StaticDataPackage.Rooms
					.put(RoomName, roomBean);
			StaticDataPackage.UserSOnline.get(LoginName).room = StaticDataPackage.Rooms
					.get(RoomName);
			doRequest();
			return true;
		}
	}

	private void doRequest() {
		for (User user : guestlists) {
			if (!user.userName.equals(LoginName)) {
				user.getRequestBean().setRequest(
						new getRequest(LoginName, RoomName));

			}

		}
	}

	private List<User> AnalyzJson(JSONArray GuestList) {
		List<User> guests = new ArrayList<User>();
		for (int i = 0; i < GuestList.size(); i++) {
			String name = GuestList.getJSONObject(i).getString("LoginName");
			guests.add(StaticDataPackage.UserSOnline.get(name));
		}
		return guests;
	}
}
