package bom;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	
	private int id;
	
	private Date dateCreated;
	
	private Product product;
	
	private Order order;
	
	private Bot bot;
	
	private Cluster cluster;
	
	private Date dateStart;
}
