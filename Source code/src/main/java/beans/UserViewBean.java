package beans;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import entities.Product;
import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.ProductService;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name="userViewBean")
@ViewScoped
public class UserViewBean implements Serializable{
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
		String userIdAsString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");
		if(StringUtils.isNotBlank(userIdAsString)) {
			Optional<User> optionalUser = userService.findUser(Integer.valueOf(userIdAsString));
			if(optionalUser.isPresent()) {
				this.user = optionalUser.get();
			}else {
				logger.info("Can not find user with id: " + userIdAsString);
			}
		}else {
			logger.error("Can not get id of user from list users");
		}
		
	}
}
