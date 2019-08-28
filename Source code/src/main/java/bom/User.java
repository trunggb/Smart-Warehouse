package bom;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	private String userName;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String address;
	
	private String avatar;
	
	private Date createDate;
	
	private Date lastAccessDate;
	
	private Date lastLogoutDate;
	
	private Role role;
	
	private Active active;
}
