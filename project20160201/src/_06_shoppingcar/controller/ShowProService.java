package _06_shoppingcar.controller;

import java.util.ArrayList;
import java.util.List;

import _06_shoppingcar.model.dao.ShowProDAO;

public class ShowProService {
	private ShowProDAO DAO = new ShowProDAO();
	private List<ProductBean> result;
	public List<ProductBean> select(){
		result = new  ArrayList<>();
		result = DAO.select();
		return result;
	}
	public List<ProductBean> getResult() {
		return result;
	}

	
	
	
}
