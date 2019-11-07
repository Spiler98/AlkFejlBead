package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity {
    
    @Column(nullable = false)
    private String userName;    
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String emailAddress;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @JsonIgnore
    @ManyToMany(targetEntity = ShowTime.class, mappedBy = "viewers")
    private List<ShowTime> showTimes;
    
    @JsonIgnore
    @OneToMany(targetEntity = Seat.class, mappedBy = "owner")
    private List<Seat> seats;
    
}
