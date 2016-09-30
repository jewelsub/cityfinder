package cityfinder.service;

import cityfinder.domain.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CityFinder {

    private static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    private static final Logger log = LoggerFactory.getLogger(CityFinder.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CsvWriter csvWriter;

    public void findCity(String[] cityParam) {
        log.info("looking for city: " + Arrays.asList(cityParam));
        List<City> cities = new ArrayList<>();

        Arrays.asList(cityParam).forEach(p -> {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).path(p);
            City[] cityList = restTemplate.getForObject(builder.build().encode().toUri(), City[].class);
            cities.addAll(Arrays.asList(cityList));
        });

        csvWriter.writeFile(cities);
    }
}
