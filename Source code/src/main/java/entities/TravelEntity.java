package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="travel")
@Data

public class TravelEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="bot")
	private BotEntity bot;

	@ManyToOne
	@JoinColumn(name="order_detail")
	private OrderDetailEntity orderDetail;
	
	@ManyToOne
	@JoinColumn(name="location")
	private LocationEntity from;
	
	@ManyToOne
	@JoinColumn(name="location")
	private LocationEntity to;
	
	@Column(name="start", nullable=true)
	private Date start;
	
	@Column(name="end", nullable=true)
	private Date end;
	
}
