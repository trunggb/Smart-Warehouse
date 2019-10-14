package vn.edu.hcmut.smartwarehouse.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "end_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "last_access_date")
	private LocalDateTime lastAccessDate;

	@Column(name = "last_logout_date")
	private LocalDateTime lastLogoutDate;

	@Column(name = "role")
	private Role role;

	@Column(name = "active")
	private Active active;

}
