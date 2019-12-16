package com.app.dao;

import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;

@Repository //to tell SC that its DAO layer spring bean
@Transactional // to tell SC to auto manage txs
public class ProductDaoImpl implements IProductDao {

	@Autowired //by Type
	private SessionFactory sf;
	
	
	@Override
	public List<Product> listAllProducts() {
		String jpql = "Select p from Product p";
		
		
		return sf.getCurrentSession().createQuery(jpql,Product.class).getResultList();
	}

}
