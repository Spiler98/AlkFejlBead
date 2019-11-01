package cinema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Seat extends BaseEntity {
	
	@Column(nullable = false)
	private int row;
	
	@Column(nullable = false)
	private int column;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(targetEntity = CinemaHall.class)
	private CinemaHall cinemaHall;
	
}
