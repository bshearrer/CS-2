import java.util.ArrayList;

/**
 * Created by kyle on 4/14/15.
 */
public class City implements GeographicObject, PopulationCalculator{
    private String name;
    private int population;
    private Province hostProvince;
    private Country hostCountry;
    private ArrayList<BoundarySegments> cityLimits;
    private ArrayList<River> cityRivers;

    /**
     * Constructor to make base City with no relations
     *
     * @param name
     * @param population
     */
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    /**
     * Constructor to make full City object
     *
     * @param name
     * @param population
     * @param hostProvince
     * @param hostCountry
     * @param cityLimits
     * @param cityRivers
     */
    public City(String name, int population, Province hostProvince, Country hostCountry, ArrayList<BoundarySegments> cityLimits, ArrayList<River> cityRivers) {
        this.name = name;
        this.population = population;
        this.hostProvince = hostProvince;
        this.hostCountry = hostCountry;
        this.cityLimits = cityLimits;
        this.cityRivers = cityRivers;
    }

    /*
    GETTERS AND SETTERS
     */

    /**
     * Getter for name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for population
     *
     * @return
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Setter for population
     *
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Getter for hostProvince
     *
     * @return
     */
    public Province getHostProvince() {
        return hostProvince;
    }

    /**
     * Setter for the hostProvince
     *
     * @param hostProvince
     */
    public void setHostProvince(Province hostProvince) {
        this.hostProvince = hostProvince;
    }

    /**
     * Getter for the hostCountry
     *
     * @return
     */
    public Country getHostCountry() {
        return hostCountry;
    }

    /**
     * Setter for the hostCountry
     *
     * @param hostCountry
     */
    public void setHostCountry(Country hostCountry) {
        this.hostCountry = hostCountry;
    }

    /**
     * Getter for the cityLimts
     *
     * @return cityLimits
     */
    public ArrayList<BoundarySegments> getCityLimits() {
        return cityLimits;
    }

    /**
     * Setter for the cityLimits
     *
     * @param cityLimits
     */
    public void setCityLimits(ArrayList<BoundarySegments> cityLimits) {
        this.cityLimits = cityLimits;
    }

    /**
     * Getter for the cityRivers
     *
     * @return cityRivers
     */
    public ArrayList<River> getCityRivers() {
        return cityRivers;
    }

    /**
     * Setter for the cityRivers
     *
     * @param cityRivers
     */
    public void setCityRivers(ArrayList<River> cityRivers) {
        this.cityRivers = cityRivers;
    }

    /*
    EXTERNAL METHODS
     */

    /**
     * Method to add a river to a city without replacing the whole ArrayList
     *
     * @param river the River object to add to the ArrayList
     */
    public void addRiver(River river){
        this.cityRivers.add(river);
    }


    /**
     * Returns the total area of the city
     *
     * @return
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Returns the total length of the border segments
     *
     * @return total length
     */
    @Override
    public double boundaryLength() {
        double total = 0;
        for(int i = 0; i < cityLimits.size(); i++){
            total += cityLimits.get(i).getLengthMeters();
        }
        return total;
    }

    /**
     * Returns the population of the City
     *
     * @return population
     */
    @Override
    public long calculatePopulation() {
        return population;
    }

    /**
     * Find all the neighbors of the City
     *
     * @return
     */
    @Override
    public ArrayList<GeographicObject> neighbors() {
        return null;
    }
}
