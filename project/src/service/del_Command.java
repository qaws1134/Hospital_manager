package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

public class delCommand implements BasicCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String p_num =request.getParameter("p_num");
		DAO dao = new DAO();
		
		dao.delete(p_num);
	}
}
