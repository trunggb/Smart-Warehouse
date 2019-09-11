package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import bom.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
@Data

public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="type_product")
	private TypeProductEntity typeProduct;
	
	@Column(name="image")
	private String image;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="status")
	private ProductStatus status;
	
	@Column(name="in_date")
	private Date inDate;
	
	
	@Column(name="out_date")
	private Date outDate;
	
	
	@Column(name="expiry_date")
	private Date expiryDate;
}