package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.DTO;

public class SearchCommand implements BasicCommand{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		DAO dao = new DAO();
		ArrayList<DTO> search = dao.search(searchName, searchValue);
		request.setAttribute("search", search);
	}

}