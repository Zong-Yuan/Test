package _99_star;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import _00_register.MemberBean;

public class Allmember {
	private static DataSource ds = null;
	private List<MemberBean> allmb = new ArrayList<>();
	private MemberBean ok = new MemberBean();		
	
	
	public  MemberBean getOk() {
		System.out.println("ok"+ok);
		return ok;
	}



	public Allmember() {
			ds = ConnDB.getConnDB();
			String select = "select * from member";
			try {
				Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(select);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					MemberBean mb = new MemberBean();
					mb.setMem_id(Integer.valueOf(rs.getString("mem_id")));
					mb.setMail(rs.getString("mail"));
					mb.setMem_name(rs.getString("mem_name"));
					mb.setPwd(rs.getString("pwd"));
					mb.setIdentification(rs.getString("identification"));
					mb.setGender(rs.getString("gender"));
					mb.setBdate(rs.getDate("bdate"));
					mb.setPoint(rs.getInt("point"));
					mb.setJoin_date(rs.getDate("join_date"));
					allmb.add(mb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	public Object checkID(String mail, String pwd) {
		String ch = "";	
		for (MemberBean one : allmb) {
			//System.out.println(one);
			if (mail.trim().equals(one.getMail()) ) {
				if (pwd.trim().equals(one.getPwd())){
					//System.out.println("one="+ one);
					ok = one;
					return one;
				}
				return ch = "密碼錯誤";
			}
			
		}

		return ch = "帳號不存在";
	}

	public MemberBean Memodify(String mail){
		MemberBean mb = null;
		for(MemberBean one:allmb){
			if(mail.trim().equals(one.getMail())){
				return mb = one;
			}
		}
		return mb;
		
	}
}
