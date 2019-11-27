package beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Log;
import entities.Role;
import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.LogService;
import services.ProductService;

@SuppressWarnings("deprecation")
@ManagedBean(name="logBean")
@ViewScoped
public class LogBean implements Serializable {
	/**
	 * 
	 */

	@ManagedProperty(value = "#{userBean}")
	@Setter
	private UserBean userBean;

	private static final long serialVersionUID = 4098294323352760786L;

	@Getter
	@Setter
	private User loginUser;
	
	@Getter
	@Setter
	private List<Log> logs;
	
	@EJB
	LogService logService;

	Logger logger = Logger.getLogger(ProductService.class);

	@PostConstruct
	public void init() {
		if (Objects.isNull(userBean.getLoginUser()) || userBean.getLoginUser().getRole() != Role.ADMIN) {
			PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
		}
		this.loginUser = userBean.getLoginUser();
		this.logs = logService.findAll();
	}
	
	public void onClickOrderButton() {
		PrimeFaces.current().executeScript("top.redirectTo('order.xhtml')");
	}
	public void onClickProductButton() {
		PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
	}
	
	public void onClickLogoutButton() {
		userBean.setLoginUser(null);
		PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
	}
}
