package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions.add(new TouristAttraction("Tivoli", "Famous amusement park in Copenhagen with rides and entertainment."));
        attractions.add(new TouristAttraction("Nyhavn", "Colorful waterfront district in Copenhagen with cafes and restaurants."));
        attractions.add(new TouristAttraction("The Little Mermaid", "Iconic statue in Copenhagen inspired by a fairy tale."));
        attractions.add(new TouristAttraction("Roskilde Cathedral", "Historic cathedral in Roskilde with impressive architecture."));
        attractions.add(new TouristAttraction("Freetown Christiania", "Alternative neighborhood in Copenhagen known for its unique culture."));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public Optional<TouristAttraction> getAttractionByName(String name) {
        Optional<TouristAttraction> attraction = attractions.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
        return attraction;
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            TouristAttraction attraction = attractions.get(i);
            if (attraction.getName().equals(name)) {
                attractions.set(i, updatedAttraction);
                return;
            }
        }
    }

    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equals(name));
    }
}





