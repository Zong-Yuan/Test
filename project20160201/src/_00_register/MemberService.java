package _00_register;

import java.sql.SQLException;

public class MemberService {
	MemberBean mben = null;
	
	public void insert() throws SQLException{
		MemberDAO mb = new MemberDAO();
		mb.insert(mben);
	}
	
	public void member(String mail, String pwd, String mem_name, String identification,
			 String gender, java.util.Date bdate){
		mben = new MemberBean(mail, pwd, mem_name, identification, gender, bdate);
		//System.out.println("bdate"+bdate);
	}


	
}
