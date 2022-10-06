package pl.sampleproject;

import java.util.List;
import java.util.stream.Collectors;

public class CitySearch {
    private static final int MINIMUM_LETTERS = 2;
    private static final List<String> EMPTY_LIST = List.of();
    private CitiesRepository citiesRepository;

    public CitySearch(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public List<String> search(String input) {

        if(input.equals("*"))
            return citiesRepository.getCities();
        if(input.length() < MINIMUM_LETTERS)
            return EMPTY_LIST;

        return citiesRepository.getCities()
                .stream()
                .sorted()
                .filter(s -> s.toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }
}
