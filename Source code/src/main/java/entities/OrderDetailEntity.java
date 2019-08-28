package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_detail")
@Data

public class OrderDetailEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="date_created", nullable=true)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="product")
	private ProductEntity product;
	
	@OneToOne
	private OrderEntity order;
	
	@OneToOne
	private BotEntity bot;
	
	@OneToOne
	private ClusterEntity cluster;
	
	@Column(name="date_start")
	private Date dateStart;

}
