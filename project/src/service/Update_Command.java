package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

public class cristalCommand implements BasicCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String P_NUM= request.getParameter("P_NUM"); 
		String P_NAME= request.getParameter("P_NAME"); 
		String P_PERNUM = request.getParameter("P_PERNUM"); 
		String P_GENDER = request.getParameter("P_GENDER"); 

		DAO dao =new DAO();
		dao.update(P_NUM,P_NAME,P_PERNUM,P_GENDER);
	}

}
