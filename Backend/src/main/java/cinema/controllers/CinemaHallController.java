package cinema.controllers;

import cinema.entities.CinemaHall;
import cinema.repositories.CinemaHallRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("cinemahall")
public class CinemaHallController {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<CinemaHall>> getAll(){
        return new ResponseEntity(cinemaHallRepository.findAll(), HttpStatus.OK);
}
    
    @PostMapping("")
    public ResponseEntity<CinemaHall> post(@RequestBody CinemaHall cinemaHall) {
        return ResponseEntity.ok(cinemaHallRepository.save(cinemaHall));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CinemaHall> getById(@PathVariable Long id){
       Optional<CinemaHall> oCinemaHall = cinemaHallRepository.findById(id);
        if (!oCinemaHall.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oCinemaHall.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CinemaHall> updateById(@PathVariable Long id, @RequestBody CinemaHall cinemaHall) {
        Optional<CinemaHall> oCinemaHall = cinemaHallRepository.findById(id);
        if (oCinemaHall.isPresent()) {
            cinemaHall.setId(id);
            return ResponseEntity.ok(cinemaHallRepository.save(cinemaHall));
        }
        return ResponseEntity.notFound().build();
    }
    
            
    @DeleteMapping("/{id}")
    public ResponseEntity<CinemaHall> deleteById(@PathVariable Long id) {
        Optional<CinemaHall> oCinemaHall = cinemaHallRepository.findById(id);
        if (!oCinemaHall.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cinemaHallRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
