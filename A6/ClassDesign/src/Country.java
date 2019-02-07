import java.util.ArrayList;

/**
 * Created by kyle on 4/14/15.
 */
public class Country implements GeographicObject, PopulationCalculator{
    private String name;
    private ArrayList<BoundarySegments> countryBorders;
    private ArrayList<Province> provinces;
    private ArrayList<City> cities;
    private City capital;
    private ArrayList<River> countryRivers;

    /**
     * Base constructor
     *
     * @param name
     */
    public Country(String name) {
        this.name = name;
    }

    /**
     * Constructor for full Country object
     *
     * @param name
     * @param countryBorders
     * @param provinces
     * @param cities
     * @param capital
     * @param countryRivers
     */
    public Country(String name, ArrayList<BoundarySegments> countryBorders, ArrayList<Province> provinces, ArrayList<City> cities, City capital, ArrayList<River> countryRivers) {
        this.name = name;
        this.countryBorders = countryBorders;
        this.provinces = provinces;
        this.cities = cities;
        this.capital = capital;
        this.countryRivers = countryRivers;
    }

    /*
    GETTERS AND SETTERS
     */

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return countryBorders
     */
    public ArrayList<BoundarySegments> getCountryBorders() {
        return countryBorders;
    }

    /**
     *
     * @param countryBorders
     */
    public void setCountryBorders(ArrayList<BoundarySegments> countryBorders) {
        this.countryBorders = countryBorders;
    }

    /**
     *
     * @return provinces
     */
    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    /**
     *
     * @param provinces
     */
    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }

    /**
     *
     * @return cities
     */
    public ArrayList<City> getCities() {
        return cities;
    }

    /**
     *
     * @param cities
     */
    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    /**
     *
     * @return capital
     */
    public City getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     */
    public void setCapital(City capital) {
        this.capital = capital;
    }

    /**
     *
     * @return countryRivers
     */
    public ArrayList<River> getCountryRivers() {
        return countryRivers;
    }

    /**
     *
     * @param countryRivers
     */
    public void setCountryRivers(ArrayList<River> countryRivers) {
        this.countryRivers = countryRivers;
    }

    /**
     * Calculate the area of the country
     *
     * @return area
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Calculates the total area of the boundaries
     *
     * @return total
     */
    @Override
    public double boundaryLength() {
        double total = 0;
        for(int i = 0; i < countryBorders.size(); i++){
            total += countryBorders.get(i).getLengthMeters();
        }
        return total;
    }

    /**
     * Calculates total population of all cities and the cities belonging to provinces of the country
     *
     * @return total
     */
    @Override
    public long calculatePopulation() {
        findProvinceCities();

        long total = 0;
        for (int i = 0; i < cities.size(); i++){
            total += cities.get(i).getPopulation();
        }
        return total;
    }

    /**
     * Adds all province cities to the ArrayList of cities
     */
    public void findProvinceCities(){
        for (int i = 0; i < provinces.size(); i++){
            cities.addAll(provinces.get(i).getCities());
        }
    }

    /**
     * Returns all the neighbors of the country
     *
     * @return
     */
    @Override
    public ArrayList<GeographicObject> neighbors() {
        return null;
    }
}
