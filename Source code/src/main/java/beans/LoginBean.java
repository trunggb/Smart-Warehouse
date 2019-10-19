package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6445092217844175676L;
	
	@Getter
	@Setter
	private User user;
	
	@EJB
	UserService userService;
	
	public void onClickLoginButton() {
		// redirect to product page
		PrimeFaces.current().executeScript("top.redirectTo('product.xhtml')");
	}
	
}
