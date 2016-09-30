package cityfinder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    @JsonProperty(value = "_id")
    private long id;

    private String key;
    private String name;
    private String fullName;

    @JsonProperty(value = "iata_airport_code")
    private String iataAirportCode;

    private String type;
    private String country;

    @JsonProperty(value = "geo_position")
    private GeoPosition geoPosition;

    private String locationId;
    private Boolean inEurope;
    private String countryCode;
    private Boolean coreCountry;
    private Long distance;

    public City() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iataAirportCode='" + iataAirportCode + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", geoPosition=" + geoPosition +
                ", locationId='" + locationId + '\'' +
                ", inEurope=" + inEurope +
                ", countryCode='" + countryCode + '\'' +
                ", coreCountry=" + coreCountry +
                ", distance=" + distance +
                '}';
    }
}
