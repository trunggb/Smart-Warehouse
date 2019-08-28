package bom;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
	
	private int id;
	
	private Action action;
	
	private User user;
	
	private Date createDate;
	
	private String oldData;
	
	private String newData;
	
	private boolean isProduct;
	
	private boolean isUser;
	
	private boolean isTypeProduct;
	
	private boolean isOrder;
	
	private boolean isOrderDetail;
	
	private boolean isBot;
}
