package com.niit.model;

 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity

public class Cart implements Serializable
{
	
   @Id
   @GeneratedValue
   private int cartId;
   private int cartProductID;
   
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="userMailId")
   
   private User cartUserDetails;
   private double cartPrice;
   private int cartStock;
    

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getCartProductID() {
	return cartProductID;
}

public void setCartProductID(int cartProductID) {
	this.cartProductID = cartProductID;
}

public User getCartUserDetails() {
	return cartUserDetails;
}

public void setCartUserDetails(User cartUserDetails) {
	this.cartUserDetails = cartUserDetails;
}

public double getCartPrice() {
	return cartPrice;
}

public void setCartPrice(double cartPrice) {
	this.cartPrice = cartPrice;
}

public int getCartStock() {
	return cartStock;
}

public void setCartStock(int cartStock) {
	this.cartStock = cartStock;
}

public String getCartImage() {
	return cartImage;
}

public void setCartImage(String cartImage) {
	this.cartImage = cartImage;
}

public String getCartProductName() {
	return cartProductName;
}

public void setCartProductName(String cartProductName) {
	this.cartProductName = cartProductName;
}

private String cartImage;
   private String cartProductName;
   
   public   Cart()
   {
	   
   }
   
   public Cart(int cartId,int cartProductID,User cartUserDetails,Double cartPrice,
		   int cartStock,  String cartProductName)
   {
	   
	   this.cartId = cartId;
	   this.cartProductID=cartProductID;
	   this.cartPrice=cartPrice;
	   this.cartUserDetails=cartUserDetails;
	   this.cartStock=cartStock;
	   
	   
	   
   }

 
   
}
