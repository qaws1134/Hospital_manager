package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

public class P_addCommand implements BasicCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 
		String P_NAME= request.getParameter("P_NAME"); 
		String P_PERNUM = request.getParameter("P_PERNUM"); 
		String P_GENDER = request.getParameter("P_GENDER"); 

		DAO dao = new DAO();
		dao.P_insert(P_NAME, P_PERNUM, P_GENDER);
	}

}
