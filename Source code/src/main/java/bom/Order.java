package bom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	private int id;
	
	private OderStatus status;
	
	private int total;
	
	private User user;
	
	private String comment;
}
