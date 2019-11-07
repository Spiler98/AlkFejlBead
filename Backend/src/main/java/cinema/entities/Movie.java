package cinema.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Movie extends BaseEntity {
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String director;
	
	@Column(nullable = false)
	private String synopsis;
	
	@Column(nullable = false)
	private LocalTime duration;
	
	@Column(nullable = false)
	private String posterPath;
	
	@Column(nullable = false)
	private LocalDateTime uploadDate;
	
	@OneToMany(targetEntity = ShowTime.class, mappedBy = "movie")
	private List<ShowTime> showTimes;
	
}
