package vn.edu.hcmut.smartwarehouse.log;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmut.smartwarehouse.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "action")
	@Enumerated
	private Action action;

	@ManyToOne
	@JoinColumn(name = "end_user")
	private User user;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "old_data")
	private String oldData;

	@Column(name = "new_data")
	private String newData;

	@Column(name = "be_product")
	private boolean beProduct;

	@Column(name = "be_user")
	private boolean beUser;

	@Column(name = "be_type_product")
	private boolean beTypeProduct;

	@Column(name = "be_order")
	private boolean beOrder;

	@Column(name = "be_order_detail")
	private boolean beOrderDetail;

	@Column(name = "be_bot")
	private boolean beBot;
}
