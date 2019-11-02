package beans;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	
	
	@ManagedProperty(value = "#{userBean}")
	@Setter
	private UserBean userBean;

	private static final long serialVersionUID = 6445092217844175676L;
	
	@Getter
	@Setter
	private String userName;
	
	@Getter
	@Setter
	private String passWord;
	
	
	@EJB
	UserService userService;
	
	public void onClickLoginButton() {
		Optional<User> user = userService.checkValidUser(userName, passWord);
		if(user.isPresent()) {
			this.userBean.setLoginUser(user.get());
			PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
		}
	}
	
}
