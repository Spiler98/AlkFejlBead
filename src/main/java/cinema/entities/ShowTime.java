package cinema.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "showtime")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShowTime extends BaseEntity {
	
	@Column(nullable = false)
	private Date start;
	
	@OneToOne(targetEntity = Movie.class, mappedBy = "showTime")
	private Movie movie;
	
	@OneToOne(targetEntity = CinemaHall.class, mappedBy = "showTime")
	private CinemaHall cinemaHall;
	
}
