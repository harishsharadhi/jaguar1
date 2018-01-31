package com.niit.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Cart;

@Repository("cartDao")
public interface CartDao {

	public void insertCart (Cart cart);
	public List<Cart> retrive();
	public Cart getCartId(int ctname);
	
}
