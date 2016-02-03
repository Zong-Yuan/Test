package _06_shoppingcar.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import _06_shoppingcar.model.dao.CarDetailDAO;
import _06_shoppingcar.model.dao.ShoppingCarDAO;
import _06_shoppingcar.model.dao.ShowProDAO;
import _99_star.ConnDB;

public class BuyProService {

	public ProductBean findPro(int id) {

		if (id != 0) {
			ShowProDAO proDAO = new ShowProDAO();
			return proDAO.selectId(id);
		}
		return null;
	}

	public void insertShopCar(ShoppingCarBean bean, ShoppingCar car, CarDetailBean carDetail, String id) {
		ShoppingCarDAO shop = new ShoppingCarDAO();
		ShoppingCarBean carBean = new ShoppingCarBean();
		carBean = shop.select(bean.getMem_Id());
		Connection conn = null;
		int pk = 0;
		DataSource ds = ConnDB.getConnDB();
		if (carBean == null) {
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
				pk = shop.insert(bean, conn);
				if (pk != 0) {
					carDetail.setShoppingcart_Id(pk);
					insertCarDetail(carDetail, conn);
					car.addToCar(id, carDetail);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return;
		} else {
			pk = carBean.getShoppingCart_Id();
			carDetail.setShoppingcart_Id(pk);
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
				insertCarDetail(carDetail, conn);
				car.addToCar(id, carDetail);
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return;
	}

	public void insertCarDetail(CarDetailBean bean, Connection conn) {
		CarDetailDAO detail = new CarDetailDAO();
		CarDetailBean oldBean = new CarDetailBean();
		oldBean = detail.select(bean.getProd_Id(), bean.getMem_Id());
		if (oldBean == null) {
			detail.insert(bean, conn);
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
			List<CarDetailBean> list = new ArrayList<CarDetailBean>();
			list = detail.selectCar(bean.getShoppingcart_Id());
			int x = 0;
			for (CarDetailBean eveone : list) {
				x = x + eveone.getSubtotal();
			}
			ShoppingCarDAO shop = new ShoppingCarDAO();
			ShoppingCarBean carBean = new ShoppingCarBean();
			carBean = shop.select(bean.getMem_Id());
			if (x != 0) {
				carBean.setTotal(x);
				shop.update(carBean);
			}
			return ;
		} else {

			return ;
		}

	}

	

}
