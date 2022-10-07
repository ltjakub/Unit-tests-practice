package pl.sampleproject.CitySearch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.sampleproject.CitySearch.CitiesRepository;
import pl.sampleproject.CitySearch.CitySearch;

import java.util.List;
import static org.mockito.Mockito.when;

class CitySearchTest {
    @Mock
    CitiesRepository citiesRepository;
    @InjectMocks
    CitySearch citySearch;
    @BeforeEach
            public void init() {
        MockitoAnnotations.openMocks(this);
    }
    List<String> cities = List.of("Paris", "Valencia", "Vancouver");
    @Test
    public void shouldReturnEmptyListForLessThan2Letters() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("P");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of());

    }
    @Test
    public void shouldReturnExactCityFromList() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("Paris");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Paris"));

    }
    @Test
    public void shouldReturnCityWithLowerCaseInput() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("paris");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Paris"));
    }
    @Test
    public void shouldReturnCityWithUpperCaseInput() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("PARIS");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Paris"));
    }
    @Test
    public void shouldReturnCitiesWithOnly2Letters() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("Pa");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Paris"));
    }
    @Test
    public void shouldReturnTwoCities() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("va");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Valencia", "Vancouver"));
    }
    @Test
    public void shouldReturnAllCities() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("*");
        //then
        Assertions.assertThat(foundCities).isEqualTo(cities);
    }
    @Test
    public void shouldReturnParisWithOnlyMiddlePartGiven() {
        //given
        //when
        when(citiesRepository.getCities()).thenReturn(cities);
        List<String> foundCities = citySearch.search("ari");
        //then
        Assertions.assertThat(foundCities).isEqualTo(List.of("Paris"));
    }

}