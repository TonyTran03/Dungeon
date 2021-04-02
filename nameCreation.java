public class nameCreation {
    private String name; // private to close leakage, good form

    public nameCreation(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}