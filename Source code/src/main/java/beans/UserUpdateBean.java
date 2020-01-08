package beans;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

import entities.Action;
import entities.Log;
import entities.Role;
import entities.User;
import entities.UserStatus;
import lombok.Getter;
import lombok.Setter;
import services.LogService;
import services.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "userUpdateBean")
@ViewScoped
public class UserUpdateBean implements Serializable {
	/**
	 * 
	 */

	@ManagedProperty(value = "#{userBean}")
	@Setter
	private UserBean userBean;

	private static final long serialVersionUID = 4098294323352760786L;
	@Setter
	@Getter
	private User user;

	@EJB
	UserService userService;
	
	@EJB
	LogService logService;

	final static Logger logger = Logger.getLogger(UserService.class);

	@PostConstruct
	public void init() {
		String userIdAsString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("userId");
		if (StringUtils.isNotBlank(userIdAsString)) {
			Optional<User> optionalUser = userService.findUser(Integer.valueOf(userIdAsString));
			if (optionalUser.isPresent()) {
				this.user = optionalUser.get();
			} else {
				logger.info("Can not find user with id: " + userIdAsString);
			}
		} else {
			logger.error("Can not get id of user from list users");
		}

	}

	public UserStatus[] getUserStatus() {
		return UserStatus.values();
	}
	
	public Role[] getUserRoles() {
		return Role.values();
	}

	public void writeLog() {
		Log log = Log.builder().action(Action.UPDATE).user(userBean.getLoginUser()).logTime(new Date()).note("user "+ user.buildFullName()).build();
		logService.add(log);
	}

	public void updateUser() {
		String password = Base64.getEncoder().encodeToString(this.user.getPassword().getBytes());
		this.user.setPassword(password);
		if (this.userService.updateUser(this.user)) {
			logger.info("Update user succesfully");
			PrimeFaces.current().executeScript("parent.showSuccessMessage('User updated succesfully!')");
			writeLog();
		} else {
			logger.info("Can not update user");
			PrimeFaces.current().executeScript("parent.showErrorMessage('User update failed!')");
		}

		PrimeFaces.current().executeScript("parent.reloadPage();");
	}
}
