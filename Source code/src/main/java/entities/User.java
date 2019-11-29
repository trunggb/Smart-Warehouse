package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({ @NamedQuery(name = "findAllUser", query = "SELECT u FROM User u"),
		@NamedQuery(name = "findUserByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName") })
@Entity
@Builder
@Data
@Table(name = "end_user")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

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
	private LocalDate createDate;

	@Column(name = "last_access_date")
	private LocalDate lastAccessDate;

	@Column(name = "last_logout_date")
	private LocalDate lastLogoutDate;

	@Column(name = "role")
	private Role role;

	@Column(name = "active")
	private UserStatus status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Log> logs;

	public String buildFullName() {
		return String.join(" ", this.firstName, this.lastName);
	}
}
