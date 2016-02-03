package _06_shoppingcar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import _06_shoppingcar.controller.CarDetailBean;
import _99_star.ConnDB;

public class CarDetailDAO {
	private DataSource ds = ConnDB.getConnDB();

	private static final String select = "select * from car_detailTest where prod_id = ? and mem_id=?";

	public CarDetailBean select(int prod_id, int mem_id) {
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(select);
			){
			
			pstmt.setInt(1, prod_id);
			pstmt.setInt(2, mem_id);
			ResultSet rs = pstmt.executeQuery();
			CarDetailBean bean = new CarDetailBean();
			if (rs.next()) {
				bean.setShoppingcart_Id(rs.getInt("shoppingcart_id"));
				bean.setMem_Id(rs.getInt("mem_id"));
				bean.setSeller_Id(rs.getInt("seller_id"));
				bean.setProd_Id(rs.getInt("prod_id"));
				bean.setProd_Name(rs.getString("prod_name"));
				bean.setOrd_Date(rs.getDate("ord_date"));
				bean.setPrice(rs.getInt("price"));
				bean.setCount(rs.getInt("count"));
				bean.setSubtotal(rs.getInt("subtotal"));
				bean.setShip(rs.getString("ship"));
				bean.setOrd_Point(rs.getInt("ord_point"));
				return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return null;
	}

	private static final String selectCheck = "select * from car_detailTest where shoppingcart_id = ? ";
	public List<CarDetailBean> selectCar(int shoppingcar_id) {

		
			try (Connection conn = ds.getConnection();
					PreparedStatement	pstmt = conn.prepareStatement(selectCheck);	
					){
				pstmt.setInt(1, shoppingcar_id);
				ResultSet rs = pstmt.executeQuery();
				List<CarDetailBean> list = new ArrayList<>();
				while (rs.next()) {
					CarDetailBean bean = new CarDetailBean();
					bean.setShoppingcart_Id(rs.getInt("shoppingcart_id"));
					bean.setMem_Id(rs.getInt("mem_id"));
					bean.setSeller_Id(rs.getInt("seller_id"));
					bean.setProd_Id(rs.getInt("prod_id"));
					bean.setProd_Name(rs.getString("prod_name"));
					bean.setOrd_Date(rs.getDate("ord_date"));
					bean.setPrice(rs.getInt("price"));
					bean.setCount(rs.getInt("count"));
					bean.setSubtotal(rs.getInt("subtotal"));
					bean.setShip(rs.getString("ship"));
					bean.setOrd_Point(rs.getInt("ord_point"));
					list.add(bean);
				}
				return list;

			} catch (SQLException e) {
				e.printStackTrace();
			} 

				return null;
	}

	private static final String insert = "insert car_detailTest values(?,?,?,?,?,?,?,?,?,?,?)";

	public void insert(CarDetailBean bean, Connection conn) {
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, bean.getShoppingcart_Id());
			pstmt.setInt(2, bean.getMem_Id());
			pstmt.setInt(3, bean.getSeller_Id());
			pstmt.setInt(4, bean.getProd_Id());
			pstmt.setString(5, bean.getProd_Name());
			long time = bean.getOrd_Date().getTime();
			pstmt.setDate(6, new java.sql.Date(time));
			pstmt.setInt(7, bean.getPrice());
			pstmt.setInt(8, bean.getCount());
			pstmt.setInt(9, bean.getSubtotal());

			pstmt.setString(10, bean.getShip());
			pstmt.setInt(11, bean.getOrd_Point());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static final String update = "update car_detailTest set ord_date=?, count=?, subtotal=? where prod_id=? and mem_id=?";

	public void update(CarDetailBean bean) {
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(update);) {
			long time = bean.getOrd_Date().getTime();
			pstmt.setDate(1, new java.sql.Date(time));
			pstmt.setInt(2, bean.getCount());
			pstmt.setInt(3, bean.getSubtotal());
			pstmt.setInt(4, bean.getProd_Id());
			pstmt.setInt(5, bean.getMem_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final String delete="delete from car_detailTest where mem_id=? and prod_id=?";
	public void delete(int mem_id, int prod_id){
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(delete);) {
			pstmt.setInt(1, mem_id);
			pstmt.setInt(2, prod_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
