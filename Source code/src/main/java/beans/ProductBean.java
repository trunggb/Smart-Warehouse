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

import entities.Product;
import lombok.Getter;
import lombok.Setter;
import services.ProductService;

@SuppressWarnings("deprecation")
@ManagedBean(name="productBean")
@ViewScoped
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
	
	@Getter
	@Setter
	private Product productRemoved;
	
	
	@Inject
	ProductService productService;
	
	final static Logger logger = Logger.getLogger(ProductService.class);
	
	@PostConstruct
	public void init() {
		products = productService.findAll();
		logger.debug("Get " + products.size() + " product from database");
	}
	private void chooseProduct(Product product) {
		this.productViewed = product;
		logger.debug(productViewed);
	}
	
	public void onclickRemoveButton(Product product) {
//		this.productRemoved = product;
//		PrimeFaces.current().executeScript("PF('remove-dialog').show();");
		productService.remove(product);
		PrimeFaces.current().executeScript("location.reload();");
	}
	
	public void removeProduct() {
		productService.remove(this.productRemoved);
		PrimeFaces.current().executeScript("PF('remove-dialog').hide();");
		PrimeFaces.current().executeScript("top.showSuccessMessage(\" Product removed successfully\");");
	}
	
	public void viewProduct(Product product) {
		chooseProduct(product);
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
