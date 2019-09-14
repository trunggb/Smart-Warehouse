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

public class OrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_created", nullable=true)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;
	
	@OneToOne
	private Order order;
	
	@OneToOne
	private Bot bot;
	
	@OneToOne
	private Cluster cluster;
	
	@Column(name="date_start")
	private Date dateStart;

}
