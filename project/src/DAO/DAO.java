package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO;

public class DAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	String userid="dud";
	String passwd="011869";

	public DAO() {
		try {
			
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<DTO> D_Search (String _searchName, String _searchValue){
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "1234");
			String query;
			if(_searchName.equals("d_name")) 
			{
				
				query="select d_name,d_cls from doctor where d_cls=(select d_cls from doctor where d_name=? )";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _searchValue);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String d_name = rs.getString("D_NAME");
					String d_cls = rs.getString("D_CLS");
					
					DTO data =new DTO();
					
					data.setD_NAME(d_name);
					data.setD_CLS(d_cls);
					
					list.add(data);
					
				}
			}	
			else
			{
				query="select d_name,d_cls from doctor where d_cls like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+_searchValue+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String d_name = rs.getString("D_NAME");
					String d_cls = rs.getString("D_CLS");
					
					DTO data =new DTO();
					
					data.setD_NAME(d_name);
					data.setD_CLS(d_cls);
					
					list.add(data);
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//의사 부서 정보
	public ArrayList<DTO> D_clsif(){
			
			ArrayList<DTO> list = new ArrayList<DTO>();
			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs =null;
			
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
				String query = "select D_CLS, AVG(D_COST) AS AVGCOST, MAX(D_COST) AS MAXCOST,MIN(D_COST) AS MINCOST FROM DOCTOR GROUP BY D_CLS order by D_CLS asc";
				
				pstmt =con.prepareStatement(query);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					String d_cls=rs.getString("D_CLS");
					int avgcost = rs.getInt("AVGCOST");
					int maxcost = rs.getInt("MAXCOST");
					int mincost = rs.getInt("MINCOST");
					
					DTO data = new DTO();
					
					data.setD_CLS(d_cls);
	
					data.setAVGCOST(avgcost);
					data.setMAXCOST(maxcost);
					data.setMINCOST(mincost);
					
					list.add(data);
					}	
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null)rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null)con.close();
					}catch(SQLException e) {
						e.printStackTrace();
				}
			}
				return list;
		}
	
	/*
	    //병실 조회
		public ArrayList<DTO> insearch (String _searchName, String _searchValue){
			ArrayList<DTO> list = new ArrayList<DTO>();
			Connection con =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
				String query;
				if(_searchName.equals("p_name")) 
				{
					
					query="select P_NUM,P_PERNUM ,P_NAME,P_GENDER from patient where P_NAME like ? ORDER BY P_NUM ASC";
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, "%"+_searchValue+"%");
					rs = pstmt.executeQuery();
					while(rs.next()) {
						int p_num = rs.getInt("P_NUM");
						String p_name = rs.getString("P_NAME");
						String p_pernum= rs.getString("P_PERNUM");
						String p_gender=rs.getString("P_GENDER");
						
						DTO data =new DTO();
						
						data.setP_NUM(p_num);
						data.setP_NAME(p_name);
						data.setP_PERNUM(p_pernum);
						data.setP_GENDER(p_gender);
						
						list.add(data);
					}				
				}
				else if (_searchName.equals("d_name"))
				{
					query="select * from doctor where D_NAME like ? ORDER BY D_NUM ASC";
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, "%"+_searchValue+"%");
					rs = pstmt.executeQuery();
					while(rs.next()) {		
						int d_num = rs.getInt("D_NUM");
						String d_name = rs.getString("D_NAME");
						String d_gender = rs.getString("D_GENDER");
						String d_pernum = rs.getString("D_PERNUM");
						String d_cls = rs.getString("D_CLS");
					
						DTO data =new DTO();

						data.setD_NUM(d_num);
						data.setD_NAME(d_name);
						data.setD_GENDER(d_gender);
						data.setD_PERNUM(d_pernum);
						data.setD_CLS(d_cls);
						list.add(data);
					}
						
				}
				else 
				{
					query="select * from doctor where D_CLS like ? ORDER BY D_NUM ASC";
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, "%"+_searchValue+"%");
					rs = pstmt.executeQuery();

					while(rs.next()) {

						int d_num = rs.getInt("D_NUM");
						String d_name = rs.getString("D_NAME");
						String d_gender = rs.getString("D_GENDER");
						String d_pernum = rs.getString("D_PERNUM");
						String d_cls = rs.getString("D_CLS");
					
						DTO data =new DTO();
						
						
						data.setD_NUM(d_num);
						data.setD_NAME(d_name);
						data.setD_GENDER(d_gender);
						data.setD_PERNUM(d_pernum);
						data.setD_CLS(d_cls);
						list.add(data);
					}			
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}
		

	*/
	
	//입실 입력
	public void in(String _H_NUM, String _P_NUM){

		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="UPDATE PATIENT SET H_NUM =? WHERE P_NUM=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_H_NUM));
			pstmt.setInt(2, Integer.parseInt(_P_NUM));
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//입실 출력
	public ArrayList<DTO> D_inshow(){
		
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query = "select H_NUM,H_COST,D_NAME,D_CLS from HOSPITAL h,DOCTOR d WHERE h.D_NUM = d.D_NUM order by h.H_NUM asc";
			pstmt =con.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int h_num =rs.getInt("H_NUM");
				int h_cost=rs.getInt("H_COST");
				String d_name=rs.getString("D_NAME");
				String d_cls=rs.getString("D_CLS");
				
						
				DTO data = new DTO();
				data.setH_NUM(h_num);
				data.setH_COST(h_cost);
				data.setD_NAME(d_name);
				data.setD_CLS(d_cls);
				

				list.add(data);
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
			return list;
	}
	public ArrayList<DTO> P_inshow(){
		
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query = "select P_NAME  from HOSPITAL h,PATIENT p WHERE h.H_NUM = p.H_NUM order by h.H_NUM asc";
			pstmt =con.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String p_name =rs.getString("P_NAME");
					
				DTO data = new DTO();
				data.setP_NAME(p_name);

				list.add(data);
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
			return list;
	}
	//환자 조회
	public ArrayList<DTO> search (String _searchName, String _searchValue){
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query;
			if(_searchName.equals("p_name")) 
			{
				
				query="select P_NUM,P_PERNUM ,P_NAME,P_GENDER from patient where P_NAME like ? ORDER BY P_NUM ASC";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+_searchValue+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int p_num = rs.getInt("P_NUM");
					String p_name = rs.getString("P_NAME");
					String p_pernum= rs.getString("P_PERNUM");
					String p_gender=rs.getString("P_GENDER");
					
					DTO data =new DTO();
					
					data.setP_NUM(p_num);
					data.setP_NAME(p_name);
					data.setP_PERNUM(p_pernum);
					data.setP_GENDER(p_gender);
					
					list.add(data);
				}				
			}
			else if (_searchName.equals("d_name"))
			{
				query="select * from doctor ";
				query += "	where D_NAME like ? ORDER BY D_NUM ASC";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+_searchValue+"%");
				rs = pstmt.executeQuery();
				while(rs.next()) {		
					int d_num = rs.getInt("D_NUM");
					String d_name = rs.getString("D_NAME");
					String d_gender = rs.getString("D_GENDER");
					String d_pernum = rs.getString("D_PERNUM");
					String d_cls = rs.getString("D_CLS");
				
					DTO data =new DTO();

					data.setD_NUM(d_num);
					data.setD_NAME(d_name);
					data.setD_GENDER(d_gender);
					data.setD_PERNUM(d_pernum);
					data.setD_CLS(d_cls);
					list.add(data);
				}
					
			}
			else 
			{
				query="select * from doctor";
				query += "	where D_CLS like ? ORDER BY D_NUM ASC";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+_searchValue+"%");
				rs = pstmt.executeQuery();

				while(rs.next()) {

					int d_num = rs.getInt("D_NUM");
					String d_name = rs.getString("D_NAME");
					String d_gender = rs.getString("D_GENDER");
					String d_pernum = rs.getString("D_PERNUM");
					String d_cls = rs.getString("D_CLS");
				
					DTO data =new DTO();
					
					
					data.setD_NUM(d_num);
					data.setD_NAME(d_name);
					data.setD_GENDER(d_gender);
					data.setD_PERNUM(d_pernum);
					data.setD_CLS(d_cls);
					list.add(data);
				}			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	

	
	//환자 선택
	public DTO select(String _p_num) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		DTO data = new DTO();
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="select * from patient where P_NUM=?";
			
			pstmt =con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_p_num));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				int p_num =rs.getInt("P_NUM");
				String p_name=rs.getString("P_NAME");
				String p_pernum=rs.getString("P_PERNUM");
				String p_gender=rs.getString("P_GENDER");
		
				data.setP_NUM(p_num);
				data.setP_NAME(p_name);
				data.setP_PERNUM(p_pernum);
				data.setP_GENDER(p_gender);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	//환자 수정
	public void update(String _p_num,String _p_name,String _p_pernum,String _p_gender) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="UPDATE patient SET P_NAME=?, P_PERNUM=?, P_GENDER=? where P_NUM = ?";
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, _p_name);
			pstmt.setString(2, _p_pernum);
			pstmt.setString(3, _p_gender);
			pstmt.setInt(4, Integer.parseInt(_p_num));
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//환자 삭제
	public void delete(String _p_num) {
		Connection con =null;
		PreparedStatement pstmt =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="delete from patient where P_NUM=?";
			pstmt =con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_p_num));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//환자 추가
	public void P_insert(String _P_NAME, String _P_PERNUM, String _P_GENDER){

		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="INSERT INTO PATIENT(P_NUM, P_NAME, P_PERNUM, P_GENDER) values(patient_seq.nextval,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, _P_NAME);
			pstmt.setString(2, _P_PERNUM);
			pstmt.setString(3, _P_GENDER);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//의사 추가
	public void D_insert(String _D_NAME, String _D_PERNUM, String _D_GENDER, String _D_CLS){
		

		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query="INSERT INTO DOCTOR(D_NUM, D_NAME, D_PERNUM, D_GENDER, D_CLS) values(doctor_seq.nextval,?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, _D_NAME);
			pstmt.setString(2, _D_PERNUM);
			pstmt.setString(3, _D_GENDER);
			pstmt.setString(4, _D_CLS);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//리스트 보기
	public ArrayList<DTO> P_list(){
		
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query = "select P_NUM, P_NAME, P_PERNUM, P_GENDER from PATIENT ORDER BY P_NUM ASC";
			pstmt =con.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int p_num =rs.getInt("P_NUM");
				String p_name=rs.getString("P_NAME");
				String p_pernum=rs.getString("P_PERNUM");
				String p_gender=rs.getString("P_GENDER");
			
				DTO data = new DTO();
				data.setP_NUM(p_num);
				data.setP_NAME(p_name);
				data.setP_PERNUM(p_pernum);
				data.setP_GENDER(p_gender);

				list.add(data);
				}
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
			return list;
	}
	public ArrayList<DTO> D_list(){
		
		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dud", "011869");
			String query = "select D_NUM, D_NAME, D_PERNUM, D_GENDER, D_CLS  from DOCTOR ORDER BY D_NUM ASC";
			pstmt =con.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int d_num =rs.getInt("D_NUM");
				String d_name=rs.getString("D_NAME");
				String d_pernum=rs.getString("D_PERNUM");
				String d_gender=rs.getString("D_GENDER");
				String d_cls=rs.getString("D_CLS");
				
				DTO data = new DTO();
				data.setD_NUM(d_num);
				data.setD_NAME(d_name);
				data.setD_PERNUM(d_pernum);
				data.setD_GENDER(d_gender);
				data.setD_CLS(d_cls);
				list.add(data);
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
			return list;
	}

	
	
}
