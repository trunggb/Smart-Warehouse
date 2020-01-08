package beans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import entities.User;
import lombok.Getter;
import lombok.Setter;
import services.DialogService;

@SuppressWarnings("deprecation")
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6445092217844175676L;
	
	@Getter
	@Setter
	private User loginUser;
	
	@Inject
	DialogService dialogService;
	
	public void addUser() {
		Map<String, Object> options = dialogService.createDialogOption(700,500);
		
		PrimeFaces.current().dialog().openDynamic("addUser", options, null);
	}

	
}
