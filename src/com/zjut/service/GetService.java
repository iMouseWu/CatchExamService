package com.zjut.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.httpclient.Cookie;
import com.zjut.change.Change;
import com.zjut.getcookie.GetCookie;
import com.zjut.getcxxt.GetCxxt;
import com.zjut.postcxxt.PostCxxt;

/**
 * Servlet implementation class GetService
 */
@WebServlet("/GetService")
public class GetService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String year = request.getParameter("year");
		String number = request.getParameter("number");
		Cookie[] cookie = GetCookie.getCookie(user, password);
		String viewstate = GetCxxt.getCxxt(cookie);
		List result = PostCxxt.getResult(cookie, viewstate, year, number);
		JSONArray theResult = Change.changeToJson(result);
		out.println(theResult);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
