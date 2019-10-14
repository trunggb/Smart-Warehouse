package vn.edu.hcmut.smartwarehouse.travel;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmut.smartwarehouse.bot.Bot;
import vn.edu.hcmut.smartwarehouse.location.Location;
import vn.edu.hcmut.smartwarehouse.order.detail.OrderDetail;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travel")
public class Travel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "bot")
	private Bot bot;

	@ManyToOne
	@JoinColumn(name = "order_detail")
	private OrderDetail orderDetail;

	@ManyToOne
	@JoinColumn(name = "from_loc")
	private Location from;

	@ManyToOne
	@JoinColumn(name = "to_loc")
	private Location to;

	@Column(name = "start_date")
	private LocalDateTime start;

	@Column(name = "end_date")
	private LocalDateTime end;

}
