package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.DTO;

public class selectCommand implements BasicCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String p_num =request.getParameter("p_num");
		DAO dao = new DAO();
		DTO data= dao.select(p_num);
		ArrayList<DTO> D_list=dao.D_list();
	
		request.setAttribute("D_list", D_list);
		request.setAttribute("select", data);
	}
}
