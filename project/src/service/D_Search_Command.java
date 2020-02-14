package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.DTO;

public class D_SearchCommand implements BasicCommand{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		DAO dao = new DAO();
		ArrayList<DTO> D_clsif=dao.D_clsif();
		request.setAttribute("D_clsif", D_clsif);
		ArrayList<DTO> D_list=dao.D_list();
		request.setAttribute("D_list", D_list);
		
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		ArrayList<DTO> D_Search = dao.D_Search(searchName, searchValue);
		request.setAttribute("D_Search", D_Search);
	}

}




