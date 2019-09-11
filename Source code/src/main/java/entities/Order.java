package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bom.OderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order")
@Data

public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="status", nullable=false)
	private OderStatus status;
	
	@Column(name="total")
	private int total;
	
	@ManyToOne
	@JoinColumn(name="user")
	private UserEntity user;
	
	@Column(name="comment")
	private String comment;
}
