import java.util.HashMap;
import java.util.Map;

public class NumberGuessingService {
    private static Map<DifficultyLevel, Integer> difficulyMap = populateDifficulyMap();

    public Integer getChanges(String difficulty) {
        DifficultyLevel difficultyLevel = DifficultyLevel.fromString(difficulty);
        return difficulyMap.get(difficultyLevel);
    }

    private static Map<DifficultyLevel, Integer> populateDifficulyMap() {
        Map<DifficultyLevel, Integer> difficultyMap = new HashMap<>();
        difficultyMap.put(DifficultyLevel.EASY, 10);
        difficultyMap.put(DifficultyLevel.MEDIUM, 5);
        difficultyMap.put(DifficultyLevel.HARD, 3);
        return difficultyMap;
    }
}
