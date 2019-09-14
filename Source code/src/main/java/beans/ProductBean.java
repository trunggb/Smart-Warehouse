package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Product;
import lombok.Getter;
import lombok.Setter;
import services.ProductService;

@SuppressWarnings("deprecation")
@ManagedBean(name="productBean")
@SessionScoped
public class ProductBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4098294323352760786L;
	@Getter
	@Setter
	private List<Product> products;
	
	@Setter
	@Getter
	private Product productViewed;
	
	
	@Inject
	ProductService productService;
	
	final static Logger logger = Logger.getLogger(ProductService.class);
	
	@PostConstruct
	public void init() {
		products = productService.findAll();
		logger.debug("Get " + products.size() + " product from database");
	}
	public void chooseProduct(Product product) {
		this.productViewed = product;
		logger.debug(productViewed);
		viewProduct();
	}
	private void viewProduct() {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
        PrimeFaces.current().dialog().openDynamic("viewProduct", options, null);
	}
}
