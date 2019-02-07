import java.util.ArrayList;

/**
 * Created by kyle on 4/14/15.
 */
public class Province implements GeographicObject, PopulationCalculator{
    private String name;
    private ArrayList<BoundarySegments> provinceBorders;
    private ArrayList<City> cities;
    private Country hostCountry;
    private City capital;
    private ArrayList<River> provinceRivers;

    /**
     * Base contructor, must have name
     *
     * @param name
     */
    public Province(String name) {
        this.name = name;
    }

    /**
     * Constructor for full province
     *
     * @param name
     * @param provinceBorders
     * @param cities
     * @param hostCountry
     * @param capital
     * @param provinceRivers
     */
    public Province(String name, ArrayList<BoundarySegments> provinceBorders, ArrayList<City> cities, Country hostCountry, City capital, ArrayList<River> provinceRivers) {
        this.name = name;
        this.provinceBorders = provinceBorders;
        this.cities = cities;
        this.hostCountry = hostCountry;
        this.capital = capital;
        this.provinceRivers = provinceRivers;
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
     * @return provinceBorders
     */
    public ArrayList<BoundarySegments> getProvinceBorders() {
        return provinceBorders;
    }

    /**
     *
     * @param provinceBorders
     */
    public void setProvinceBorders(ArrayList<BoundarySegments> provinceBorders) {
        this.provinceBorders = provinceBorders;
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
     * @return hostCountry
     */
    public Country getHostCountry() {
        return hostCountry;
    }

    /**
     *
     * @param hostCountry
     */
    public void setHostCountry(Country hostCountry) {
        this.hostCountry = hostCountry;
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
     * @return provinceRivers
     */
    public ArrayList<River> getProvinceRivers() {
        return provinceRivers;
    }

    /**
     *
     * @param provinceRivers
     */
    public void setProvinceRivers(ArrayList<River> provinceRivers) {
        this.provinceRivers = provinceRivers;
    }

    /*
    EXTERNAL METHODS
     */

    /**
     * Returns the area of a province
     *
     * @return area
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Returns the total length of the borders of the province
     *
     * @return total
     */
    @Override
    public double boundaryLength() {
        double total = 0;
        for(int i = 0; i < provinceBorders.size(); i++){
            total += provinceBorders.get(i).getLengthMeters();
        }
        return total;
    }

    /**
     * Returns the population of all cities in the province
     *
     * @return totalPop
     */
    @Override
    public long calculatePopulation() {
        int totalPop = 0;
        for(int i = 0; i < cities.size(); i++){
            totalPop += cities.get(i).getPopulation();
        }
        return totalPop;
    }

    /**
     * Return all the neighbors of the Province
     *
     * @return
     */
    @Override
    public ArrayList<GeographicObject> neighbors() {
        return null;
    }
}
