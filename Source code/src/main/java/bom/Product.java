package bom;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int id;
	
	private String name;
	
	private TypeProduct typeProduct;
	
	private String image;
	
	private int weight;
	
	private int amount;
	
	private ProductStatus status;
	
	private Date inDate;
	
	private Date outDate;
	
	private Date expiryDate;
}
