package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "seat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Seat extends BaseEntity {
	
	@Column(nullable = false)
	private int rowNumber;
	
	@Column(nullable = false)
	private int columnNumber;
        
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
        
	@JoinColumn
	@ManyToOne(targetEntity = User.class)
	private User owner;
        
        @JoinColumn
        @JsonIgnore
	@ManyToOne(targetEntity = CinemaHall.class)
	private CinemaHall cinemaHall;
        
        @JoinTable
        @JsonIgnore
        @ManyToMany(targetEntity = ShowTime.class)
	private List<ShowTime> showTimes;
        
}
