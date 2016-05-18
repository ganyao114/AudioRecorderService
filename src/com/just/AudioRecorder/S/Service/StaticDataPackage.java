package com.just.AudioRecorder.S.Service;

import java.util.HashMap;
import java.util.Map;

import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;

/**
 *
 * @author Administrator
 */
public class StaticDataPackage {
    public static Map<String, User> UserSOnline = new HashMap<String,User>();
    public static Map<String, RoomBean> Rooms = new HashMap<String,RoomBean>();
}
