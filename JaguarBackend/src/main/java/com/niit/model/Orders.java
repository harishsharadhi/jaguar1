package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity

public class Orders implements Serializable


{
  @Id
  @GeneratedValue
  private int orderId;
  private double total;
  public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
@ManyToOne
  @JoinColumn
  private User user;
  private String payment;
  
  
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
}
