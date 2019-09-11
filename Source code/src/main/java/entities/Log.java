package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import bom.Action;
import bom.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
@Data

public class LogEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="action")
	private Action action;
	
	@Column(name="by_user")
	private User user;
	
	@Column(name="create")
	private Date createDate;
	
	@Column(name="old_data")
	private String oldData;
	
	@Column(name="new_data")
	private String newData;
	
	@Column(name="is_product")
	private boolean isProduct;
	
	@Column(name="is_user")
	private boolean isUser;
	
	@Column(name="is_type_product")
	private boolean isTypeProduct;
	
	@Column(name="is_order")
	private boolean isOrder;
	
	@Column(name="is_order_detail")
	private boolean isOrderDetail;
	
	@Column(name="is_bot")
	private boolean isBot;
}
