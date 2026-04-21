import java.util.LinkedHashMap;
import java.util.Map;

public class RecommendationManager {
    // tänne tallennetaan kaikki listat nimellä
    private Map<String, Recommendation> recommendations;

    public RecommendationManager() {
        recommendations = new LinkedHashMap<>();
    }

    public boolean addRecommendation(String name, Recommendation recommendation) {
        // ei lisätä jos samalla nimellä löytyy jo lista
        if (recommendations.containsKey(name)) {
            return false;
        }

        recommendations.put(name, recommendation);
        return true;
    }

    public Recommendation getRecommendation(String name) {
        return recommendations.get(name);
    }

    public boolean cloneRecommendation(String oldName, String newName) {
        // kopioidaan vanha lista uudella nimellä
        Recommendation original = recommendations.get(oldName);

        if (original == null || recommendations.containsKey(newName)) {
            return false;
        }

        recommendations.put(newName, original.clone());
        return true;
    }

    public boolean exists(String name) {
        return recommendations.containsKey(name);
    }

    public void showAllRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendation lists saved.");
            return;
        }

        System.out.println("Saved recommendation lists:");
        for (String name : recommendations.keySet()) {
            System.out.println("- " + name);
        }
    }
}