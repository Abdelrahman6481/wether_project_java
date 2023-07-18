import java.util.Objects;

public class City {
    protected String name;
    private int population;
    private double PricePerDay;
    private int numOfUniversity;
    private double temperature;
    private String description;
    private static int numOfObj = 0;

    // Default constructor
    public City() {
        numOfObj++;
    }

    // Parameterized constructor
    public City(String name, int population, double temperature, String description, double PricePerDay) {
        this.name = name;
        this.population = population;
        this.temperature = temperature;
        this.description = description;
        this.PricePerDay = PricePerDay;
        numOfObj++;
    }

    protected static int getNumberofObjects() {
        return City.numOfObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getNumOfUniversity() {
        return numOfUniversity;
    }

    public void setNumOfUniversity(int numOfUniversity) {
        this.numOfUniversity = numOfUniversity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPricePerDay() {
        return PricePerDay;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", PricePerDay=" + PricePerDay +
                ", numOfUniversity=" + numOfUniversity +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (population != city.population) return false;
        if (Double.compare(city.PricePerDay, PricePerDay) != 0) return false;
        if (numOfUniversity != city.numOfUniversity) return false;
        if (Double.compare(city.temperature, temperature) != 0) return false;
        if (!Objects.equals(name, city.name)) return false;
        return Objects.equals(description, city.description);
    }

}
