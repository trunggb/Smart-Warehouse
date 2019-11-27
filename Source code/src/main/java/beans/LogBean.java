package beans;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Role;
import entities.User;
import lombok.Getter;
import lombok.Setter;
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

	Logger logger = Logger.getLogger(ProductService.class);

	@PostConstruct
	public void init() {
		if (Objects.isNull(userBean.getLoginUser()) || userBean.getLoginUser().getRole() != Role.ADMIN) {
			PrimeFaces.current().executeScript("top.redirectTo('index.xhtml')");
		}
		this.loginUser = userBean.getLoginUser();
	}
}
