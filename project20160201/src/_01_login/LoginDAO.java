package _01_login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import _99_star.ConnDB;

public class LoginDAO {
	static DataSource ds = null;

	String check = "select mail, pwd from member where mail=?";
	public String checkID(String mail, String pwd) {
		String ch = "";
		try {
			ds = ConnDB.getConnDB();
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(check);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(mail.equals(rs.getString(1))){
					if(pwd.equals(rs.getString(2))){
						ch="正確";
						return ch;
					}
					ch="密碼錯誤";
					return ch;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ch;
	}
}
