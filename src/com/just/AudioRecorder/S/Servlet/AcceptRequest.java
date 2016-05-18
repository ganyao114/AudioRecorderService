package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.just.AudioRecorder.S.Dao.Bean.AcceptReturnBean;
import com.just.AudioRecorder.S.Dao.Bean.Message;
import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPublic;
import com.just.AudioRecorder.S.Service.StaticDataPackage;

/**
 * Servlet implementation class AcceptRequest
 */
@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out=response.getWriter();
		String LoginName = request.getParameter("LoginName");
	    String RoomName = request.getParameter("RoomName");
	    RoomBean roomBean = StaticDataPackage.Rooms.get(RoomName);
	    User tmpUser = StaticDataPackage.UserSOnline.get(LoginName);
	    roomBean.RoomMenber.add(tmpUser);
	    tmpUser.room = roomBean;
	     List<Message> msgs = new ArrayList<Message>();
	    
			List<UserInfoPublic> guests = new ArrayList<UserInfoPublic>();
			
			for(User user:StaticDataPackage.UserSOnline.get(LoginName).room.RoomMenber)
			{
				guests.add(new UserInfoPublic(user.userName, user.email));
			}
			AcceptReturnBean acceptReturnBean = new AcceptReturnBean(RoomName, roomBean.RoomOwner.userName, roomBean.Message, guests);
			JSONObject jsonObject = JSONObject.fromObject(acceptReturnBean);
			out.print(jsonObject.toString());
	}
	

}
