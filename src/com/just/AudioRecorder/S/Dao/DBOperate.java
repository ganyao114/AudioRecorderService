/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
package com.just.AudioRecorder.S.Dao;

import com.just.AudioRecorder.S.Dao.Bean.UserInfoPrivate;

import java.sql.*;

public class DBOperate {

    private final String DRIVER = "com.hxtt.sql.access.AccessDriver";
    private final String DBURL = "jdbc:Access:///e:/javaweb/AudioRecorder/WebContent/WEB-INF/Database1.mdb";
    //private final String ACCOUNT = "postgres";
    //private final String PASSWORD = "123";

    public DBOperate() {
    }

    //杩炴帴鏁版嵁搴�
    public Connection CreateConn() {
        try {
            Class.forName(DRIVER).newInstance();
            Connection conn
                    = DriverManager.getConnection(DBURL);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   

    //鍏抽棴鏁版嵁搴�
    public void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //鑾峰緱宸叉敞鍐岀殑鐢ㄦ埛鐨勪俊鎭�
    public UserInfoPrivate getUser(String loginID) {
        UserInfoPrivate user = new UserInfoPrivate();
        Connection conn = CreateConn();
        if (conn == null) {
            return user;
        }

        try {
            Statement st = conn.createStatement();
            // System.out.println("SELECT COUNT(*) FROM t_user where username='"+loginID+"'");
           // ResultSet Rs = st.executeQuery("SELECT COUNT(*) FROM t_user where username='" + loginID + "'");
            String sql = "SELECT * FROM t_user where Loginname='" + loginID + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                user.setLoginName(loginID);
                user.setLoginPassword(rs.getString("loginpassword"));
                user.setMail(rs.getString("mail"));
            }
            rs.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return user;
    }

    //瀹炵幇鐢ㄦ埛淇℃伅鍐欏叆鏁版嵁搴撴柟娉�
    public void DoReginster(String username, String pwd, String email) {
    	UserInfoPrivate user = new UserInfoPrivate();
        Connection conn = CreateConn();
        if (conn == null) {
            return;
        }
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM t_user where loginname='" + username + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                String Sql = "insert into t_user(loginname,loginpassword,mail) values('" + username + "','" + pwd + "','" + email + "')";
                System.out.println(Sql);
                st.execute(Sql);
                st.close();
            } else {
                
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return;
    }
    
   
}
