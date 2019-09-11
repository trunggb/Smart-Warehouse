package web_config;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import bom.Product;
import entities.ProductEntity;
import lombok.Data;
import services.ProductService;

@Data
@SuppressWarnings("deprecation")
@ManagedBean(name = "webHandler")
@ViewScoped
public class WebHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7829540204299922642L;
	@Inject
	private ProductService productService;
	
	private List<Product> products;
	
	private Product product = new Product();
	
	
	@PostConstruct
	public void init() {
		products = productService.toBoms(productService.findAll());
	}

	public void addProduct() {
		Optional<ProductEntity> productEntity = productService.toEntity(product);
		if(productEntity.isPresent()) {
			productService.add(productEntity.get());
			PrimeFaces.current().executeScript("PF('addProduct').hide();");
		}
		
	}
	
	public void viewProduct(Product product) {
		this.product = product;
		PrimeFaces.current().executeScript("PF('updateProduct').show();");
	}
	
	public void updateProduct(Product product){
		Optional<ProductEntity> productEntity = productService.toEntity(product);
		if(productEntity.isPresent()) {
			productService.update(productEntity.get());
		}
	}

}
