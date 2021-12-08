package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Locations {
    @JsonProperty(value="Location") // For ObjectMapper
    public ArrayList<Location> locationArray;

    public ArrayList<Location> getListOfLocations() {
        return locationArray;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locations=" + locationArray +
                '}';
    }
    public void locationList(ArrayList<Location> arrayOfLocations){
        int i = 0;

        for (Location number : arrayOfLocations) {
            System.out.println(arrayOfLocations.get(i).name + "   " + arrayOfLocations.get(i).id);
            i++;
        }
    }


}
