package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Order;
import entities.OrderDetail;
import entities.OrderStatus;
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
	}

	
	public void onClickProductButton() {
		PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
		logger.debug("Get " + orders.size() + " orders from database");
	}
	
	public List<Product> completeProduct(String query) {
        List<Product> filteredProducts = new ArrayList<>();
         
        for (int i = 0; i < products.size(); i++) {
        	Product skin = products.get(i);
            if(skin.getName().toLowerCase().contains(query)) {
            	filteredProducts.add(skin);
            }
        }
         
        return filteredProducts;
    }
	
	public void onClickCreateOrder() {
		this.selectedProducts = selectedProducts.stream().distinct().collect(Collectors.toList());
		List<OrderDetail> orderDetails = this.selectedProducts.stream().map(x -> OrderDetail.builder().product(x).build()).collect(Collectors.toList());
		Order order = Order.builder().createdDate(LocalDateTime.now()).orderDeatail(orderDetails).status(OrderStatus.IN_CREATED).note(note).build();
		if(this.orderService.createOrder(order)){
			PrimeFaces.current().executeScript("parent.showSuccessMessage('Order created succesfully!')");			
		}else {
			PrimeFaces.current().executeScript("parent.showErrorMessage('Order create failed!')");			
		}
		PrimeFaces.current().executeScript("parent.reloadPage()");
	}
}
