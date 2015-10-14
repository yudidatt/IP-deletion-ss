	package com.shieldsquare.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shieldsquare.model.IPDelete;
import com.shieldsquare.service.DeleteIP_DAO_Impl;
public class ControllerForDelete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String R1=request.getParameter("R1");
		String R2=request.getParameter("R2");
		String R4=request.getParameter("R4");
		String R5=request.getParameter("R5");
		String R6=request.getParameter("R6");
		
		int sid=Integer.parseInt(request.getParameter("sid"));
		String ip_add=request.getParameter("ipaddress");
		
		/*String startDateString = request.getParameter("start_date");
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date startDate = null;
		try {
			startDate = sdf.parse(startDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String startDateStr = null;
		startDateStr = dbFormat.format(startDate);
	*/	
		
		DeleteIP_DAO_Impl deleteIPObj=new DeleteIP_DAO_Impl();
		ArrayList<IPDelete>ipdelete=deleteIPObj.deleteIPfromTable(sid, ip_add,R1,R2,R4,R5,R6);
	
		RequestDispatcher rd=request.getRequestDispatcher("showMsg.jsp");
		request.setAttribute("ip_delete", ipdelete);
		rd.forward(request, response);
		
		
		
		
	}

}
