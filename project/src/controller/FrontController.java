package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BasicCommand;
import service.D_SearchCommand;
import service.D_addCommand;
import service.D_clsifCommand;
import service.InCommand;
import service.P_addCommand;
import service.SearchCommand;
import service.cristalCommand;
import service.delCommand;
import service.mainCommand;
import service.selectCommand;

//Ŀ�ǵ� ����Ʈ


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public FrontController() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		request.setCharacterEncoding("UTF-8");
		
		BasicCommand command = null;
		String nextPage = null;
		
		//�ؽ�Ʈ������ ������ ����
		
		
		
		/*��������*/
		if(com.equals("/main.do")) {
			command=new mainCommand();
			command.execute(request, response);
			nextPage = "main.jsp";
		}
		
		//ȯ�� �߰�
		if(com.equals("/P_addui.do")) {
			nextPage = "P_add.jsp";
		}
		if(com.equals("/P_add.do")) {
			command = new P_addCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}
		//�ǻ� �߰�
		if(com.equals("/D_addui.do")) {
			nextPage = "D_add.jsp";
		}
		if(com.equals("/D_add.do")) {
			command = new D_addCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}
		
		//�ǻ� �μ� ����
		if(com.equals("/D_clsif.do")) {
			command = new D_clsifCommand();
			command.execute(request, response);
			nextPage = "D_clsif.jsp";
		}
		
		
		if(com.equals("/D_Search.do")) {
			command = new D_SearchCommand();
			command.execute(request, response);
			nextPage = "D_clsif.jsp";
		}

		//ȯ�� ��ȸ

		if(com.equals("/search.do")) {
			command = new SearchCommand();
			command.execute(request, response);
			nextPage = "search.jsp";
		}
	
		//ȯ�� ����
		if(com.equals("/delsel.do")) {
			command=new mainCommand();
			command.execute(request, response);
			nextPage = "delsel.jsp";
		}	
	
		if(com.equals("/del.do")) {
			command = new delCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}

		//ȯ�� ����
		//ȯ�� ���� ������ �̵�
		if(com.equals("/cristal.do")) {
			command=new mainCommand();
			command.execute(request, response);
			nextPage = "cristalsel.jsp";
		}
		//���� �� ���� ������ �̵�
		if(com.equals("/cristalget.do")) {
			command = new selectCommand();
			command.execute(request, response);
			nextPage = "cristal.jsp";
		}
	
		//���� �� ��������
		if(com.equals("/cristalset.do")) {
			command = new cristalCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}

		//�Խ� �� ��,ȯ�� ������ ������
		if(com.equals("/insel.do")) {
			command=new mainCommand();
			command.execute(request, response);
			nextPage = "insel.jsp";
		}
		//���� �� ���� ������ �̵�
		if(com.equals("/inget.do")) {
			command = new selectCommand();
			command.execute(request, response);
			nextPage = "in.jsp";
		}
		
		//�������� ���� �̵�
		if(com.equals("/in.do")) {
			command = new InCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}
		/*���
		//��� �� �� ���� ������
		if(equals("/outsel.do")) {
			nextPage = "outsel.jsp";
		}
		//��� Ȯ�� �޽���
		
		//��� �� ��������
		if(equals("/out.do")) {
			command = new OutCommand();
			command.execute(request, response);
			nextPage = "main.do";
		}
	*/
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

}