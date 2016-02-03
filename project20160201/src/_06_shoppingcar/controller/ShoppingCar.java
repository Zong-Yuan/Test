package _06_shoppingcar.controller;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCar {
	
	private Map<String , CarDetailBean> car = new LinkedHashMap< >();
	
	public Map<String , CarDetailBean> getCar(){
		return car;
	}
	public void addToCar(String id, CarDetailBean cb){
		//System.out.println("aaa"+car.get(id));
		
		if(car.get(id) == null){
			
			car.put(id, cb);
		}else{
			CarDetailBean old = car.get(id);
			old.setCount(cb.getCount() + old.getCount());
		}
		
		//System.out.println(id);
	}

}
