package beans;

import java.io.Serializable;
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
import services.DialogService;
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
	private transient List<Product> products;

	@Getter
	@Setter
	private Product productRemoved;

	@Inject
	ProductService productService;
	
	@Inject
	DialogService dialogService;

	Logger logger = Logger.getLogger(ProductService.class);

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
		
		PrimeFaces.current().executeScript("showSuccessMessage('Product removed succesfully!')");
		PrimeFaces.current().executeScript("reloadPage()");
	}

	public void viewProduct(Product product) {
		Map<String, Object> options = dialogService.createDialogOption(600,450);

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("viewProduct", options, params);
	}
	
	public void updateProduct(Product product) {
		Map<String, Object> options = dialogService.createDialogOption(700,500);

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("updateProduct", options, params);
	}
	
	public void addProduct() {
		Map<String, Object> options = dialogService.createDialogOption(700,500);
		
		PrimeFaces.current().dialog().openDynamic("addProduct", options, null);
	}

	public void onClickOrderButton() {
		PrimeFaces.current().executeScript("top.redirectTo('order.xhtml')");
	}
}
