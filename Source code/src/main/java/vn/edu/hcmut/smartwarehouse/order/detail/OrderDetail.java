package vn.edu.hcmut.smartwarehouse.order.detail;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmut.smartwarehouse.bot.Bot;
import vn.edu.hcmut.smartwarehouse.cluster.Cluster;
import vn.edu.hcmut.smartwarehouse.order.Order;
import vn.edu.hcmut.smartwarehouse.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@CreatedDate
	private LocalDateTime dateCreated;

	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;

	@OneToOne
	private Order order;

	@OneToOne
	private Bot bot;

	@OneToOne
	private Cluster cluster;

	private LocalDateTime dateStart;

}
