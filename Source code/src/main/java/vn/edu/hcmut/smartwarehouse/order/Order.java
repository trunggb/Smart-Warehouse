package vn.edu.hcmut.smartwarehouse.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmut.smartwarehouse.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "status")
	private OrderStatus status;

	@Column(name = "total")
	private int total;

	@ManyToOne
	@JoinColumn(name = "end_user")
	private User user;

	@Column(name = "comment")
	private String comment;
}
