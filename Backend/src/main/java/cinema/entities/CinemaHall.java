package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cinemahall")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CinemaHall extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int rowCount;
	
	@Column(nullable = false)
	private int columnCount;
	
	@OneToMany(targetEntity = Seat.class, mappedBy = "cinemaHall")
	private List<Seat> seats;
	
        @JoinTable
	@ManyToMany(targetEntity = ShowTime.class)
        @JsonIgnore
	private List<ShowTime> showTimes;
}
