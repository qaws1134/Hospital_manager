package DTO;

public class DTO {

	/*���� ���̺�*/
	int H_NUM;			//���ǹ�ȣ
	int H_COST;			//������

	
	/*�ǻ� ���̺�*/
	int D_NUM;			//�ǻ� ��ȣ
	String D_NAME;		//�ǻ� �̸�
	String D_PERNUM;	//�ǻ� �ֹι�ȣ
	String D_GENDER;    //�ǻ� ����
	String D_CLS;  		//�ǻ� ������ȣ
	int D_COST;
	int AVGCOST;
	int MAXCOST;
	int MINCOST;
	
	/*ȯ�� ���̺�*/
	int P_NUM;			//ȯ�ڹ�ȣ
	String P_NAME;		//ȯ���̸�
	String P_PERNUM;	//�ֹι�ȣ
	String P_GENDER;	//����


	
	public DTO() {}
	public DTO(	int D_NUM, String D_NAME,	String D_PERNUM,	String D_GENDER,
			String D_CLS, int P_NUM,int AVGCOST,int MAXCOST, int MINCOST,
			int D_COST,String P_NAME,String P_PERNUM,String P_GENDER, int H_COST,int H_NUM ) {
		this. D_NUM=	D_NUM;		
		this. D_NAME=	D_NAME;	
		this. D_PERNUM=D_PERNUM;	
		this. D_GENDER=  D_GENDER;  
		this. D_CLS = D_CLS;		
		
		this. D_COST=D_COST;
		this. AVGCOST=AVGCOST;
		this. MAXCOST=MAXCOST;
		this. MINCOST=MINCOST;
		
		this. P_NUM=	P_NUM;	
		this. P_NAME=P_NAME	;	
		this. P_PERNUM=	P_PERNUM;
		this. P_GENDER=P_GENDER;

		this. H_COST=H_COST;
		this. H_NUM=H_NUM;
	}
	
	
	
	public int getD_COST() {
		return D_COST;
	}
	public void setD_COST(int d_COST) {
		D_COST = d_COST;
	}
	public int getAVGCOST() {
		return AVGCOST;
	}
	public void setAVGCOST(int aVGCOST) {
		AVGCOST = aVGCOST;
	}
	public int getMAXCOST() {
		return MAXCOST;
	}
	public void setMAXCOST(int mAXCOST) {
		MAXCOST = mAXCOST;
	}
	public int getMINCOST() {
		return MINCOST;
	}
	public void setMINCOST(int mINCOST) {
		MINCOST = mINCOST;
	}
	public int getH_NUM() {
		return H_NUM;
	}
	public void setH_NUM(int h_NUM) {
		H_NUM = h_NUM;
	}
	public int getH_COST() {
		return H_COST;
	}
	public void setH_COST(int h_COST) {
		H_COST = h_COST;
	}
	public int getD_NUM() {
		return D_NUM;
	}
	public void setD_NUM(int d_NUM) {
		D_NUM = d_NUM;
	}
	public String getD_NAME() {
		return D_NAME;
	}
	public void setD_NAME(String d_NAME) {
		D_NAME = d_NAME;
	}
	public String getD_PERNUM() {
		return D_PERNUM;
	}
	public void setD_PERNUM(String d_PERNUM) {
		D_PERNUM = d_PERNUM;
	}
	public String getD_GENDER() {
		return D_GENDER;
	}
	public void setD_GENDER(String d_GENDER) {
		D_GENDER = d_GENDER;
	}
	public String getD_CLS() {
		return D_CLS;
	}
	public void setD_CLS(String d_CLS) {
		D_CLS = d_CLS;
	}
	public int getP_NUM() {
		return P_NUM;
	}
	public void setP_NUM(int p_NUM) {
		P_NUM = p_NUM;
	}
	public String getP_NAME() {
		return P_NAME;
	}
	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}
	public String getP_PERNUM() {
		return P_PERNUM;
	}
	public void setP_PERNUM(String p_PERNUM) {
		P_PERNUM = p_PERNUM;
	}
	public String getP_GENDER() {
		return P_GENDER;
	}
	public void setP_GENDER(String p_GENDER) {
		P_GENDER = p_GENDER;
	}
}