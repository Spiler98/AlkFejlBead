package cinema.controllers;

import cinema.entities.User;
import cinema.repositories.UserRepository;
import cinema.security.AuthenticatedUser;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("logoff")
    public ResponseEntity logoff() {
        authenticatedUser.setUser(null);
        return ResponseEntity.ok(0);
    }
    
    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User cinemaHall) {
        return ResponseEntity.ok(userRepository.save(cinemaHall));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
       Optional<User> oCinemaHall = userRepository.findById(id);
        if (!oCinemaHall.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oCinemaHall.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User cinemaHall) {
        Optional<User> oCinemaHall = userRepository.findById(id);
        if (oCinemaHall.isPresent()) {
            cinemaHall.setId(id);
            return ResponseEntity.ok(userRepository.save(cinemaHall));
        }
        return ResponseEntity.notFound().build();
    }
    
            
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        Optional<User> oCinemaHall = userRepository.findById(id);
        if (!oCinemaHall.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
