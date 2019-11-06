package cinema.controllers;

import cinema.entities.ShowTime;
import cinema.repositories.ShowTimeRepository;
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
@RequestMapping("showtime")
public class ShowTimeController {
   
    @Autowired
    private ShowTimeRepository showTimeRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<ShowTime>> getAll(){
        return new ResponseEntity(showTimeRepository.findAll(), HttpStatus.OK);
}
    
    @PostMapping("")
    public ResponseEntity<ShowTime> post(@RequestBody ShowTime showTime ){
        return ResponseEntity.ok(showTimeRepository.save(showTime));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> getById(@PathVariable Long id){
       Optional<ShowTime> oShowTime = showTimeRepository.findById(id);
        if (!oShowTime.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oShowTime.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ShowTime> updateById(@PathVariable Long id, @RequestBody ShowTime showTime) {
        Optional<ShowTime> oShowTime = showTimeRepository.findById(id);
        if (oShowTime.isPresent()) {
            showTime.setId(id);
            return ResponseEntity.ok(showTimeRepository.save(showTime));
        }
        return ResponseEntity.notFound().build();
    }
    
            
    @DeleteMapping("/{id}")
    public ResponseEntity<ShowTime> deleteById(@PathVariable Long id) {
        Optional<ShowTime> oShowTime = showTimeRepository.findById(id);
        if (!oShowTime.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        showTimeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
