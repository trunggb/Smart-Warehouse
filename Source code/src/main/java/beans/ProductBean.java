package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@ManagedBean(name = "productBean")
@ViewScoped
public class ProductBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4098294323352760786L;
	@Getter
	@Setter
	private List<Product> products;

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

	public void onclickRemoveButton(Product product) {
		this.productRemoved = product;
		PrimeFaces.current().executeScript("PF('remove-dialog').show();");
	}

	public void removeProduct() {
		productService.remove(this.productRemoved);
//		FacesContext context = FacesContext.getCurrentInstance();
//        
//        context.addMessage(null, new FacesMessage("Successful",  "Product removed!") );
		PrimeFaces.current().executeScript("reloadPage()");
	}

	public void viewProduct(Product product) {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 600);
		options.put("height", 400);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("viewProduct", options, params);
	}
	
	public void updateProduct(Product product) {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 600);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("updateProduct", options, params);
	}
}
