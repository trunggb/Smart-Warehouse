package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({ @NamedQuery(name = "findAllProduct", query = "SELECT p FROM Product p") })
@Entity
@Table(name = "product")
@Data
@Builder

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "type_product")
	private TypeProduct typeProduct;

	@Column(name = "image")
	private String image;

	@Column(name = "weight")
	private int weight;

	@Column(name = "amount")
	private int amount;

	@Column(name = "status")
	private ProductStatus status;

	@Column(name = "in_date")
	private LocalDate inDate;

	@Column(name = "out_date")
	private LocalDate outDate;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
}
