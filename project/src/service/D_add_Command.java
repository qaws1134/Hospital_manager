package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

public class D_addCommand implements BasicCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 
		String D_NAME= request.getParameter("D_NAME"); 
		String D_PERNUM = request.getParameter("D_PERNUM"); 
		String D_GENDER = request.getParameter("D_GENDER"); 
		String D_CLS = request.getParameter("D_CLS");
		
		DAO dao = new DAO();
		dao.D_insert(D_NAME, D_PERNUM, D_GENDER, D_CLS);
	}

}
