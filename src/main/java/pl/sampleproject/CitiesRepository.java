package pl.sampleproject;

import java.util.Arrays;
import java.util.List;

public class CitiesRepository {

    private List<String> cities = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valencia", "Vancouver", "Amsterdam", "Vienna", "Sydney", "New York City", "London", "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul");

    public List<String> getCities() {
        return cities;
    }

}
