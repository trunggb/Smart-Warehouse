package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.ProductStatus;
import entities.Role;
import entities.User;
import entities.UserStatus;
import lombok.Getter;
import lombok.Setter;
import services.DialogService;
import services.LogService;
import services.ProductService;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "userManagementBean")
@ViewScoped
public class UserManagementBean implements Serializable {
	/**
	 * 
	 */

	@ManagedProperty(value = "#{userBean}")
	@Setter
	private UserBean userBean;

	private static final long serialVersionUID = 4098294323352760786L;
	
	@Getter
	@Setter
	private transient List<User> users;
	@Getter
	@Setter
	private transient List<User> usersFiltered;
	
	@Getter
	@Setter
	private transient List<String> allStatus = new ArrayList<>();
	
	
	@Getter
	@Setter
	private User loginUser;

	@Inject
	DialogService dialogService;

	@EJB
	LogService logService;
	
	@EJB
	UserService userService;

	Logger logger = Logger.getLogger(ProductService.class);

	@PostConstruct
	public void init() {
		if (Objects.isNull(userBean.getLoginUser()) || userBean.getLoginUser().getRole() != Role.ADMIN) {
			PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
		} else {
			UserStatus[] statuses = UserStatus.values();
			for (UserStatus status : statuses) {
				allStatus.add(status.name());
			}
			this.loginUser = userBean.getLoginUser();
			this.users = userService.findAll();
		}

		

	}


	public void writeLog() {
//		Log log = Log.builder().action(Action.DELETE).user(userBean.getLoginUser()).logTime(new Date())
//				.note("<product> " + productRemoved.getName()).build();
//		logService.add(log);
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
	public void onClickProductButton() {
		PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
	}
}
