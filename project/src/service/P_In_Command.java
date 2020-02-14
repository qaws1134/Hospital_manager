package service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

public class InCommand implements BasicCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String H_NUM= request.getParameter("H_NUM"); 
		String P_NUM= request.getParameter("P_NUM"); 
		DAO dao =new DAO();
		dao.in(H_NUM,P_NUM);
	}

}
