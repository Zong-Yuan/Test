package _00_register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _99_star.ConnDB;

public class MemberDAO {
	MemberBean mb = new MemberBean();
	Connection conn = null;
	static DataSource ds = null;
	
	String select = "select * from member";
	public List<MemberBean> select(){
		try {
			ds = ConnDB.getConnDB();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			List<MemberBean> arbean = new ArrayList<MemberBean>();
			while(rs.next()){
			MemberBean mb = new MemberBean();
				mb.setMem_id(rs.getInt("mem_id"));
				mb.setMail(rs.getString("mail"));
				mb.setPwd(rs.getString("pwd"));
				rs.getString("mem_name");
				rs.getString("identification");
				rs.getString("gender");
				rs.getDate("bdate");
				rs.getInt("point");
				rs.getString("join_date");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}
	String insert = "insert into member(mail,pwd,mem_name,identification,gender,bdate) values(?,?,?,?,?,?)";
	public boolean insert(MemberBean mb) throws SQLException{
		try {
			ds = ConnDB.getConnDB();
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(insert);			
			pstmt.setString(1, mb.getMail());
			pstmt.setString(2, mb.getPwd());
			pstmt.setString(3, mb.getMem_name());
			pstmt.setString(4, mb.getIdentification());
			pstmt.setString(5, mb.getGender());
			long time = mb.getBdate().getTime();
			//System.out.println(time);
			java.sql.Date count = new java.sql.Date(time); 
			pstmt.setDate(6, count);

			//System.out.println("today" + new java.sql.Date(day.getTime()));	
			
			pstmt.executeUpdate();
			
			
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
