package _06_shoppingcar.controller.caredit;

import java.util.ArrayList;
import java.util.List;

import _06_shoppingcar.controller.CarDetailBean;
import _06_shoppingcar.controller.ShoppingCarBean;
import _06_shoppingcar.model.dao.CarDetailDAO;
import _06_shoppingcar.model.dao.ShoppingCarDAO;

public class UpdateCarService {

	public void delete(CarDetailBean bean) {
		CarDetailDAO detail = new CarDetailDAO();
		
		detail.delete(bean.getMem_Id(), bean.getProd_Id());
		List<CarDetailBean> list = detail.selectCar(bean.getShoppingcart_Id());
		if (list.isEmpty()) {
			ShoppingCarDAO car = new ShoppingCarDAO();
			car.delete(bean.getMem_Id());
			return;
		} else {
			List<CarDetailBean> carlist = new ArrayList<CarDetailBean>();
			carlist = detail.selectCar(bean.getShoppingcart_Id());
			int x = 0;
			for (CarDetailBean eveone : carlist) {
				x = x + eveone.getSubtotal();
			}
			ShoppingCarDAO shop = new ShoppingCarDAO();
			ShoppingCarBean carBean = new ShoppingCarBean();
			carBean = shop.select(bean.getMem_Id());
			if (x != 0) {
				carBean.setTotal(x);
				shop.update(carBean);
			}
		}
	}

	public void update(CarDetailBean bean) {
		CarDetailDAO detail = new CarDetailDAO();
		CarDetailBean oldBean = new CarDetailBean();
		oldBean = detail.select(bean.getProd_Id(), bean.getMem_Id());
		oldBean.setCount(bean.getCount());
		oldBean.setSubtotal(bean.getSubtotal());
		detail.update(oldBean);

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
	}
}
