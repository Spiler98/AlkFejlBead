package cinema.repositories;

import cinema.entities.ShowTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends CrudRepository<ShowTime, Long> {
    
}
