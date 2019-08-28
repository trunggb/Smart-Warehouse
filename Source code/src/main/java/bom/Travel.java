package bom;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
	
	private int id;
	
	private Bot bot;
	
	private OrderDetail orderDetail;
	
	private Location from;
	
	private Location to;
	
	private Date start;
	
	private Date end;
}
