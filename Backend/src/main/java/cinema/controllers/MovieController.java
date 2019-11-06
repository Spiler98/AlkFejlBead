package cinema.controllers;

import cinema.entities.Movie;
import cinema.repositories.MovieRepository;
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
@RequestMapping("movie")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Movie>> getAll(){
        return new ResponseEntity(movieRepository.findAll(), HttpStatus.OK);
}
    
    @PostMapping("")
    public ResponseEntity<Movie> post(@RequestBody Movie movie ){
        return ResponseEntity.ok(movieRepository.save(movie));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable Long id){
       Optional<Movie> oMovie = movieRepository.findById(id);
        if (!oMovie.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oMovie.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateById(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> oMovie = movieRepository.findById(id);
        if (oMovie.isPresent()) {
            movie.setId(id);
            return ResponseEntity.ok(movieRepository.save(movie));
        }
        return ResponseEntity.notFound().build();
    }
    
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteById(@PathVariable Long id) {
        Optional<Movie> oMovie = movieRepository.findById(id);
        if (!oMovie.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
