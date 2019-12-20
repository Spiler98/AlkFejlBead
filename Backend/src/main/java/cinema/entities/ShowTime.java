package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private LocalDateTime startTime;
	
        @JoinColumn
        @JsonIgnore
	@ManyToOne(targetEntity = Movie.class)
	private Movie movie;
	
	@ManyToMany(targetEntity = CinemaHall.class, mappedBy = "showTimes")
	private List<CinemaHall> cinemaHalls;
        
        @ManyToMany(targetEntity = Seat.class, mappedBy = "showTimes")
	private List<Seat> seats;
	
        @JoinTable
	@ManyToMany(targetEntity = User.class)
	private List<User> viewers;
}
