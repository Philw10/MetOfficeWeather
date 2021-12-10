package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    public String id;
    public String latitude;
    public String longitude;
    public String name;
    public String region;
    public String unitaryAuthArea;
    public String elevation;

    @Override
    public String toString() {
        return "Location{" +
                "elevation='" + elevation + '\'' +
                ", id='" + id + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", unitaryAuthArea='" + unitaryAuthArea + '\'' +
                '}';
    }
    public String searchLocationId(String cityName, ArrayList<Location> location){
        int i = 0;
        String locationId = null;
        for (Location number: location){
            if (location.get(i).name.equals(cityName)){
                locationId = location.get(i).id;
                break;
            }else{
                locationId = "Not found";
            }
        i++;
        }
        return locationId;
    }
    public void locationList(ArrayList<Location> arrayOfLocations){
        int i = 0;

        for (Location number : arrayOfLocations) {
            System.out.println(arrayOfLocations.get(i).name);
            i++;
        }
    }
}
