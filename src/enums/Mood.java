package enums;

public enum Mood {
    HAPPY("радостное"),
    SAD("грустное"),
    NORMAL("нормальное"),
    ANRGY("злое"),
    HUNGRY("голоден"),
    FULL("ПОЕЛ") {};

    private final String representation;

    Mood(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }


    @Override
    public String toString() {
        return "Mood{" +
                "representation='" + representation + '\'' +
                '}';
    }
}
