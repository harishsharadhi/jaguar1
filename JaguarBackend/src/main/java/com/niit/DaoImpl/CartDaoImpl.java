package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.CartDao;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao

{
    
	@Autowired
    SessionFactory sessionFactory;

    
    public CartDaoImpl(SessionFactory sessionFactory)
    {
    	
    	this.sessionFactory=sessionFactory;
    }
    
    
    @Transactional
	public List<Cart> retrive()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cd =session.createQuery("from Cart").list();
		session.getTransaction().commit();
		return cd;
		 
	}
	
    
    
    
    public void insertCart(Cart cart)
    {
    	Session session= sessionFactory.openSession();
    	session.beginTransaction();
    	session.persist(cart);//predefined persistence method//save or update
    	session.getTransaction().commit();
    }
    @SuppressWarnings("unchecked")
    public List<Cart> findByCartID(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr = null;
		try
		{
			session.beginTransaction();
			cr = (List<Cart>)session.createQuery("from Cart wher userMailId=:email").setString("email", userId).list();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
    
    public Cart getCartById(int cartProductId, String userEmail)//MyCart option on header
    {
    	
    	Session session =sessionFactory.openSession();
    	Cart cr = null;
    	session.beginTransaction();
    	cr =(Cart)session.createQuery("from cart where userMailId=:email and cartProductID=:id").setString("email",userEmail).setInteger("pid", cartProductId).uniqueResult();
    	session.getTransaction().commit();
    	return cr;
    }
    
    public void deleteCart(int cartId)
    {
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	Cart cr =(Cart)session.get(Cart.class, cartId);
    	session.delete(cr);
    	session.getTransaction().commit();
    
    }

	

    public void updateCart(Cart cm)
    {
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	Cart cr =(Cart)session.get(Cart.class,cm);
    	session.update(cr);
    	session.getTransaction().commit();
    
    }


	 
	}
    
    

 
    
    

