package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({ @NamedQuery(name = "findAllOrder", query = "SELECT o FROM Order o") })
@Entity
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
	LocalDate createdDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status")
	private OrderStatus status;
	
}
