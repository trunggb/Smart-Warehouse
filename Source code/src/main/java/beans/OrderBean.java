package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Order;
import entities.Product;
import lombok.Getter;
import lombok.Setter;
import services.OrderService;

@SuppressWarnings("deprecation")
@ManagedBean(name="orderBean")
@ViewScoped
public class OrderBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4098294323352760786L;
	@Getter
	@Setter
	private List<Order> orders;
	
	
	@Inject
	OrderService orderService;
	
	final static Logger logger = Logger.getLogger(OrderService.class);
	
	@PostConstruct
	public void init() {
		orders = orderService.findAll();
		logger.debug("Get " + orders.size() + " orders from database");
	}
}
