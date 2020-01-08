package beans;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Role;
import entities.User;
import entities.UserStatus;
import lombok.Getter;
import lombok.Setter;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name="userAddBean")
@ViewScoped
public class UserAddBean implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4098294323352760786L;
	@Setter
	@Getter
	private User user;
	
	@EJB
	UserService userService;
	
	
	final static Logger logger = Logger.getLogger(UserService.class);
	
	@PostConstruct
	public void init() {
		this.user = new User();
	}
	
	public Role[] getUserRoles() {
		return Role.values();
	}
	
	public void addUser() {
		String password = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
		user.setPassword(password);
		user.setStatus(UserStatus.ACTIVE);
		user.setCreateDate(new Date());
		this.userService.create(user);
		
		PrimeFaces.current().executeScript("parent.showSuccessMessage('User added succesfully!')");
		PrimeFaces.current().executeScript("parent.reloadPage();");
	}
	
}
