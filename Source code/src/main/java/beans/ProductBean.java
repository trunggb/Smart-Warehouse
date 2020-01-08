package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Action;
import entities.Log;
import entities.Product;
import entities.ProductStatus;
import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.DialogService;
import services.LogService;
import services.ProductService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "productBean")
@ViewScoped
public class ProductBean implements Serializable {
	/**
	 * 
	 */

	@ManagedProperty(value = "#{userBean}")
	@Setter
	private UserBean userBean;

	private static final long serialVersionUID = 4098294323352760786L;
	@Getter
	@Setter
	private transient List<Product> products;

	@Getter
	@Setter
	private transient List<Product> productFiltered;

	@Getter
	@Setter
	private Product productRemoved;

	@Getter
	@Setter
	private User loginUser;

	@Getter
	@Setter
	private List<String> allStatus = new ArrayList<>();

	@Inject
	ProductService productService;

	@Inject
	DialogService dialogService;

	@EJB
	LogService logService;

	Logger logger = Logger.getLogger(ProductService.class);

	@PostConstruct
	public void init() {
		if (Objects.isNull(userBean.getLoginUser())) {
			PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
		} else {
			ProductStatus[] statuses = ProductStatus.values();
			for (ProductStatus productStatus : statuses) {
				allStatus.add(productStatus.toString());
			}
			this.loginUser = userBean.getLoginUser();
			products = productService.findAll();
			logger.debug("Get " + products.size() + " product from database");
		}

	}

	public void onclickRemoveButton(Product product) {
		this.productRemoved = product;
		PrimeFaces.current().executeScript("PF('remove-dialog').show();");
	}

	public void writeLog() {
		Log log = Log.builder().action(Action.DELETE).user(userBean.getLoginUser()).logTime(new Date())
				.note("product " + productRemoved.getName()).build();
		logService.add(log);
	}

	public void removeProduct() {
		try {
			productService.remove(this.productRemoved);
			writeLog();
			PrimeFaces.current().executeScript("showSuccessMessage('Product removed succesfully!')");
			PrimeFaces.current().executeScript("reloadPage()");
		} catch (Exception e) {
			PrimeFaces.current().executeScript("showErrorMessage('This product still in order!')");
		}
	}

	public void viewProduct(Product product) {
		Map<String, Object> options = dialogService.createDialogOption(600, 450);

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("viewProduct", options, params);
	}

	public void updateProduct(Product product) {
		Map<String, Object> options = dialogService.createDialogOption(700, 550);

		Map<String, List<String>> params = new HashMap<>();
		List<String> productId = new ArrayList<>(); // just send one id
		productId.add(String.valueOf(product.getId()));
		params.put("productId", productId);
		PrimeFaces.current().dialog().openDynamic("updateProduct", options, params);
	}

	public void addProduct() {
		Map<String, Object> options = dialogService.createDialogOption(700, 550);

		PrimeFaces.current().dialog().openDynamic("addProduct", options, null);
	}

	public void onClickOrderButton() {
		PrimeFaces.current().executeScript("top.redirectTo('order.xhtml')");
	}

	public void onClickHistoryButton() {
		PrimeFaces.current().executeScript("top.redirectTo('history.xhtml')");
	}

	public void onClickLogoutButton() {
		userBean.setLoginUser(null);
		PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
	}
	public void onClickUserButton() {
		PrimeFaces.current().executeScript("top.redirectTo('user.xhtml')");
	}
}
