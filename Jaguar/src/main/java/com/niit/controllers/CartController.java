// package com.niit.controllers;
//
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.security.Principal;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.niit.Dao.UserDao;
//import com.niit.DaoImpl.CartDaoImpl;
//import com.niit.DaoImpl.OrdersDaoImpl;
//import com.niit.DaoImpl.ProductDaoImpl;
//import com.niit.DaoImpl.UserDaoImpl;
//import com.niit.model.Cart;
//import com.niit.model.Orders;
//import com.niit.model.Product;
//import com.niit.model.User;
//import com.niit.Dao.SupplierDao;
//import com.niit.Dao.CategoryDao;
//import com.niit.Dao.ProductDao;
//import com.niit.Dao.CartDao;
//import com.niit.Dao.OrderDao;
//
//@SuppressWarnings("unused")
//@Controller
//@RequestMapping("/admin")
//public class CartController {
//
//	@Autowired 
//	SupplierDao supplierDao;
//	
//	@Autowired
//	CategoryDao categoryDao;
//	
//	@Autowired
//	ProductDao productDao;
//	
//	@Autowired
//	CartDao cartDao;
//	
//	@Autowired
//	OrderDao orderDao;
//	
//	@Autowired
//	UserDao userDao;
//	
//	@RequestMapping(value="/prodDetails/${p.pid}")
//	public ModelAndView prodDet(@PathVariable("pid")int pid)
//	{
//		ModelAndView mv=new ModelAndView();
//		Product prod=productDao.findByPID(pid);
//		mv.addObject("prod",prod);
//		mv.setViewName("prodDetails");
//		return mv;
//	}
//	@RequestMapping(value="addToCart",method=RequestMethod.POST)
//	public ModelAndView addtocart(HttpServletRequest request, String prodName)
//	{
//		ModelAndView mv=new ModelAndView();
//		Principal principal=request.getUserPrincipal();
//		String userEmail=principal.getName();
//		try
//		{
//			int pid=Integer.parseInt(request.getParameter("pid"));
//			Double price=Double.parseDouble(request.getParameter("pPrice"));
//			int qty=Integer.parseInt(request.getParameter("pQty"));
//			String pname=request.getParameter("prodName");
//			String imgName=request.getParameter("imgName");
//			Cart cartExist=((CartDaoImpl) cartDao).getCartById(pid,userEmail);
//			if(cartExist==null)
//			{
//				Cart cm=new Cart();
//				cm.setCartPrice(price);
//				cm.setCartProductID(pid);
//				cm.setCartStock(qty);
//				cm.setCartImage(imgName);
//				cm.setCartProductName(prodName);
//				
//				User u=((UserDaoImpl) userDao).findUserByEmail(userEmail);
//				cm.setCartUserDetails(u);
//				cartDao.insertCart(cm);
//			}
//			else if(cartExist!=null)
//			{
//				Cart cm=new Cart();
//				cm.setCartId(cartExist.getCartId());
//				cm.setCartPrice(price);
//				cm.setCartProductID(pid);
//				cm.setCartStock(cartExist.getCartStock()+qty);
//				cm.setCartImage(imgName);
//				cm.setCartProductName(prodName);
//				
//				User u=((UserDaoImpl)userDao).findUserByEmail(userEmail);
//				cm.setCartUserDetails(u);
//				((CartDaoImpl) cartDao).updateCart(cm);
//			}
//			mv.addObject("cartInfo",((CartDaoImpl) cartDao).findByCartID(userEmail));
//			mv.setViewName("cart");
//			return mv;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//			mv.addObject("cartInfo",((CartDaoImpl) cartDao).findByCartID(userEmail));
//			mv.setViewName("cart");
//			}
//		return mv;
//		}
//@RequestMapping(value="/checkout", method=RequestMethod.GET)
//public ModelAndView checkoutProcess(HttpServletRequest req, UserDaoImpl userDaoImpl, CartDaoImpl cartDaoImpl)
//{
//	ModelAndView mv= new ModelAndView();
//	Principal principal=req.getUserPrincipal();
//	String userEmail=principal.getName();
//	User u=userDaoImpl.findUserByEmail(userEmail);
//	List<Cart> cart=cartDaoImpl.findByCartID(userEmail);
//	mv.addObject("user",u);
//	mv.addObject("cart",cart);
//	return mv;
//}
//@RequestMapping(value="/Orderprocess",method=RequestMethod.POST)
//public ModelAndView orderProcess(HttpServletRequest req, UserDaoImpl userDaoImpl, OrdersDaoImpl ordersDaoImpl)
//{
//	ModelAndView mv= new ModelAndView();
//	Orders ord= new Orders();
//	Principal principal=req.getUserPrincipal();
//	String userEmail=principal.getName();
//	Double total=Double.parseDouble(req.getParameter("total"));
//	String payment=req.getParameter("payment");
//	User u=userDaoImpl.findUserByEmail(userEmail);
//	ord.setUser(u);
//	ord.setTotal(total);
//	ord.setPayment(payment);
//	ordersDaoImpl.insertOrder(ord);
//	mv.addObject("orderDetails",u);
//	mv.setViewName("ack");
//	return mv;
//}
//}	
//	
//	
//
// 
