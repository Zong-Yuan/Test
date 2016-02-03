package _06_shoppingcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import _06_shoppingcar.controller.ProductBean;
import _99_star.ConnDB;



public class ShowProDAO {
	
	private DataSource ds = ConnDB.getConnDB();
	
	private final String select = "select * from productTest";
	public List<ProductBean> select(){
		List<ProductBean> result = null;
		try (Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(select);
			){
			ResultSet rs  = ps.executeQuery();
			result = new ArrayList<ProductBean>();
			while(rs.next()){
				ProductBean bean = new ProductBean();
				bean.setProdId(rs.getInt(1));
				bean.setMemId(rs.getInt(2));
				bean.setProductName(rs.getString(3));
				bean.setSize(rs.getString(4));
				bean.setColor(rs.getString(5));
				bean.setCount(rs.getInt(6));
				bean.setPrice(rs.getInt(7));
				bean.setBrand(rs.getString(8));
				bean.setGender(rs.getString(9));
				bean.setPart(rs.getString(10));
				bean.setLanchDate(rs.getDate(11));
				bean.setNote(rs.getString(12));
				
				
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	private final String selectId = "select * from productTest where prod_id=?";
	public ProductBean selectId(int id){
		
		try (Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(selectId);	
			){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			ProductBean bean = null;
			if(rs.next()){
				bean = new ProductBean();
				bean.setProdId(rs.getInt(1));
				bean.setMemId(rs.getInt(2));
				bean.setProductName(rs.getString(3));
				bean.setSize(rs.getString(4));
				bean.setColor(rs.getString(5));
				bean.setCount(rs.getInt(6));
				bean.setPrice(rs.getInt(7));
				bean.setBrand(rs.getString(8));
				bean.setGender(rs.getString(9));
				bean.setPart(rs.getString(10));
				bean.setLanchDate(rs.getDate(11));
				
			}
			return bean;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	

}
