package tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.CREATED);
    }

    @PostMapping("/update/{name}")
    public ResponseEntity<?> updateAttraction(@PathVariable String name, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateAttraction(name, updatedAttraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<?> deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
