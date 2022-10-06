package pl.sampleproject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CitiesRepository citiesRepository = new CitiesRepository();
        CitySearch citySearch = new CitySearch(citiesRepository);
        List<String> result = citySearch.search("*");
        System.out.println(result);
    }
}
