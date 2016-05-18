package com.just.AudioRecorder.S.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.just.AudioRecorder.S.Dao.Bean.User;
import com.just.AudioRecorder.S.Dao.Bean.UserInfoPublic;
import com.just.AudioRecorder.S.Service.StaticDataPackage;

/**
 * Servlet implementation class GetUsersOnline
 */
@WebServlet("/GetUsersOnline")
public class GetUsersOnline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsersOnline() {
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
		response.setContentType("text/html;charest=UTF-8");
		PrintWriter out=response.getWriter();
		String LoginName = request.getParameter("LoginName");
		List<UserInfoPublic> list = new ArrayList<UserInfoPublic>();
		for (Map.Entry<String, User> entity : StaticDataPackage.UserSOnline.entrySet()) {            
            if(entity.getValue().room==null)
             {
                 list.add(new UserInfoPublic(entity.getValue().userName, entity.getValue().email));
             }
		}
		JSONArray array = JSONArray.fromObject(list);
		out.write(array.toString());
	}

}
