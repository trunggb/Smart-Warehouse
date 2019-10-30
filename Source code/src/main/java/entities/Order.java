package entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findAllOrder", query = "SELECT o FROM Order o")
@Entity
@Builder
@Data
@Table(name = "product_order")
public class Order {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "by_user")
	User user;
	
	@Column(name = "created_date")
	LocalDateTime createdDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status")
	private OrderStatus status;
	
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDeatail;
	
}
