package tourism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction getAttractionByName(String name) {
        Optional<TouristAttraction> attractionOptional = touristRepository.getAttractionByName(name);
        return attractionOptional.orElse(null);
    }

    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(name, updatedAttraction);
    }

    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }
}
