package cinema.repositories;

import cinema.entities.CinemaHall;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends CrudRepository<CinemaHall, Long> {
    
    Optional<CinemaHall> findByName(String name);
    Optional<CinemaHall> deleteByName(String name);
    
}
