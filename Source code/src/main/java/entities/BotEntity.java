package entities;

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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bot")
@Data

public class BotEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="location")
	private LocationEntity currentLocation;
	
	@ManyToOne
	@JoinColumn(name="location")
	private LocationEntity initLocation;
	
}
