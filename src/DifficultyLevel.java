import java.util.Objects;

public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD;

    public static DifficultyLevel fromString(String value) {
        for(DifficultyLevel value2: DifficultyLevel.values()) {
            if (Objects.equals(value2.toString(), value)) {
                return value2;
            }
        }

        return null;
    }
}
