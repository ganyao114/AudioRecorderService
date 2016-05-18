/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.AudioRecorder.S.Service;
import com.just.AudioRecorder.S.Dao.DBOperate;
import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPrivate;

/**
 *
 * @author Administrator
 */
public class UserLogin {
    public UserInfoPrivate login(String username,String pwd)
    {
        if(username == null || username.isEmpty()
                || pwd == null || pwd.isEmpty())
        {
            return null;
        }
        DBOperate dbo = new DBOperate();
        UserInfoPrivate user = dbo.getUser(username); 
         
        if(user.getLoginName().equals(username)&&
                user.getLoginPassword().equals(pwd))
        {
            return user;
        }
        return null;
    }
}
