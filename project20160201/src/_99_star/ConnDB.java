package _99_star;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnDB {
	final Connection conn = null;
	private static DataSource ds = null;
	static{
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/DBserver");
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	public static DataSource getConnDB(){
		return ds;
	}
}
