package cinema.entities;

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
	private int rowCount;
	
	@Column(nullable = false)
	private int columnCount;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

        @JoinColumn
	@ManyToOne(targetEntity = CinemaHall.class)
	private CinemaHall cinemaHall;
        
        @JoinTable
        @ManyToMany(targetEntity = ShowTime.class)
	private List<ShowTime> showTimes;
        
}
