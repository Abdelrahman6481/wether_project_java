public class Country {
    protected String name;
    private String continent;
    private int population;
    private String description;
    private static int numOfObj = 0;

    public Country() {
        numOfObj++;
    }

    public Country(String name, String continent, int population, String description) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.description = description;
    }

    protected static int getNumberofObjects() {
        return Country.numOfObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population='" + population + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
