package vn.edu.hcmut.smartwarehouse.bot;

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
import vn.edu.hcmut.smartwarehouse.location.Location;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bot")
public class Bot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "current_location")
	private Location currentLocation;

	@ManyToOne
	@JoinColumn(name = "init_location")
	private Location initLocation;

}
