package cinema.controllers;

import cinema.entities.CinemaHall;
import cinema.entities.Seat;
import cinema.repositories.CinemaHallRepository;
import cinema.repositories.SeatRepository;
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
@RequestMapping("seat")
public class SeatController {
   
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Seat>> getAll(){
        return new ResponseEntity(seatRepository.findAll(), HttpStatus.OK);
}
    
    @PostMapping("")
    public ResponseEntity<Seat> post(@RequestBody Seat seat ){
        return ResponseEntity.ok(seatRepository.save(seat));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getById(@PathVariable Long id){
        Optional<Seat> oSeat = seatRepository.findById(id);
        if (!oSeat.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oSeat.get());
    }
    
    @GetMapping("/cinemahall/{id}")
    public ResponseEntity<Iterable<Seat>> getByCinemaHallId(@PathVariable Long id){
        Optional<CinemaHall> oCinemaHall= cinemaHallRepository.findById(id);
        if (!oCinemaHall.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oCinemaHall.get().getSeats());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateById(@PathVariable Long id, @RequestBody Seat seat) {
        Optional<Seat> oSeat = seatRepository.findById(id);
        if (oSeat.isPresent()) {
            seat.setId(id);
            return ResponseEntity.ok(seatRepository.save(seat));
        }
        return ResponseEntity.notFound().build();
    }
    
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Seat> deleteById(@PathVariable Long id) {
        Optional<Seat> oSeat = seatRepository.findById(id);
        if (!oSeat.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        seatRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
