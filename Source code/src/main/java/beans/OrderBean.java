package beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Order;
import entities.OrderDetail;
import entities.Product;
import lombok.Getter;
import lombok.Setter;
import services.DialogService;
import services.OrderService;
import services.ProductService;

@SuppressWarnings("deprecation")
@ManagedBean(name="orderBean")
@ViewScoped
public class OrderBean implements Serializable {
	private static final int NUM_PROD = 5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4098294323352760786L;
	@Getter
	@Setter
	private List<Order> orders;
	
	@Getter
	@Setter
	private List<Product> products;
	
	@Getter
	@Setter
	private List<OrderDetail> orderDetails;
	
	@Getter
	@Setter
	private List<Product> selectedProducts;
	
	@Getter
	@Setter
	private String note;
	
	@Inject
	OrderService orderService;
	
	@Inject
	ProductService productService;

	@Inject
	DialogService dialogService;
	
	Logger logger = Logger.getLogger(ProductService.class);
	
	@PostConstruct
	public void init() {
		this.orders = orderService.findAll();
		this.products = productService.findAll();
		this.orderDetails = new ArrayList<>();
		for(int i = 0; i < NUM_PROD; i++) {
			this.orderDetails.add(new OrderDetail());
		}
	}

	
	public void onClickProductButton() {
		PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
		logger.debug("Get " + orders.size() + " orders from database");
	}
	
	
	public void onClickCreateOrder() throws ParseException {
//		System.out.println("OKKKKKKKKKKKKKKKKKKKKKKKKKK");
			Order order = Order.builder().createdDate(new Date()).orderDeatail(orderDetails).build();
			System.out.println(order);
//			this.orderService.createOrder(order);
//			PrimeFaces.current().executeScript("showSuccessMessage('Order created succesfully!')");
//			PrimeFaces.current().executeScript("reloadPage();");
//		OrderDetail orderDetail1 = OrderDetail.builder().product(products.get(0)).build();
//		OrderDetail orderDetail2 = OrderDetail.builder().product(products.get(1)).build();
//		Order order = Order.builder().createdDate(new Date()).orderDeatail(Arrays.asList(orderDetail1,orderDetail2)).build();
//		this.orderService.createOrder(order);
//		PrimeFaces.current().executeScript("showSuccessMessage('Product added succesfully!')");
//		PrimeFaces.current().executeScript("reloadPage();");
		
	}
}
