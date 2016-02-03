package _06_shoppingcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import _06_shoppingcar.controller.ShoppingCarBean;
import _99_star.ConnDB;

public class ShoppingCarDAO {
	private DataSource ds = ConnDB.getConnDB();
	
	private static final String select="select * from  shoppingCarTest where mem_id = ?";
	public ShoppingCarBean select(int mem_Id){
			
		try ( 	Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(select);){
			pstmt.setInt(1, mem_Id);
			ResultSet rs = pstmt.executeQuery();
			ShoppingCarBean bean = new ShoppingCarBean();
			if(rs.next()){
				bean.setShoppingCart_Id(rs.getInt(1));
				bean.setMem_Id(rs.getInt(2));
				bean.setOrd_Date(rs.getDate(3));
				bean.setTotal(rs.getInt(4));
				return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	private static final String insert = "insert into shoppingCarTest(mem_id,ord_date,total) values(?,?,?)";
	public int insert(ShoppingCarBean bean ,  Connection conn) {
		
		PreparedStatement pstms = null; 
		try {
			pstms = conn.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			pstms.setInt(1, bean.getMem_Id());
			long time = bean.getOrd_Date().getTime();
			if (time != 0) {
				pstms.setDate(2, new java.sql.Date(time));
			} else {
				pstms.setDate(2, null);
			}
			pstms.setInt(3, bean.getTotal());
			
			int i = pstms.executeUpdate();
			ResultSet rs = null;
			if (i != 0) {
				rs = pstms.getGeneratedKeys();
				if(rs != null && rs.next()){
					return rs.getInt(1);					
				}
			}else{
				return 0;
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (pstms != null) {
				try {
					pstms.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	private static final String update="update shoppingCarTest set total=? where mem_id=?";
	public void update(ShoppingCarBean bean){
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(update);
			){
			pstmt.setInt(1, bean.getTotal());
			pstmt.setInt(2, bean.getMem_Id());
			pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
	}
	
	private static final String delete="delete from shoppingCarTest where mem_id=?";
	public void delete(int mem_id){
		
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(delete);
				){
			pstmt.setInt(1, mem_id);
			pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
