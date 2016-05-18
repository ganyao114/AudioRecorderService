package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.just.AudioRecorder.S.Dao.Bean.Message;
import com.just.AudioRecorder.S.Dao.Bean.RequestBean;
import com.just.AudioRecorder.S.Dao.Bean.RoomBean;
import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPublic;
import com.just.AudioRecorder.S.Service.StaticDataPackage;

/**
 * Servlet implementation class GetRequest
 */
@WebServlet("/GetRequest")
public class GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out = response.getWriter();
		String LoginName = request.getParameter("LoginName");
		RequestBean requestBean = StaticDataPackage.UserSOnline.get(LoginName)
				.getRequestBean();

		requestBean.Guests.clear();
		RoomBean roomBean = StaticDataPackage.UserSOnline.get(LoginName).room;
		if (roomBean != null) {
			for (User user : StaticDataPackage.UserSOnline.get(LoginName).room.RoomMenber) {
				requestBean.Guests
						.add(new UserInfoPublic(user.userName, user.email));
			}

		}
		
		JSONObject jsonObject = JSONObject.fromObject(requestBean);
		System.out.println(jsonObject.toString());
		out.print(jsonObject.toString());
		synchronized (requestBean) {
			requestBean.Msgs.clear();
			requestBean.stoped = "";
			requestBean.request = null;
		}
	}

}
