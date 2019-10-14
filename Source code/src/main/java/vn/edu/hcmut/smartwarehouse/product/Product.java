package vn.edu.hcmut.smartwarehouse.product;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmut.smartwarehouse.product.type.ProductType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = -5984908048402920520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "type_product")
	private ProductType type;

	private String image;

	private int weight;

	private int amount;

	private ProductStatus status;

	private LocalDateTime inDate;

	private LocalDateTime outDate;

	private LocalDateTime expiryDate;
}
