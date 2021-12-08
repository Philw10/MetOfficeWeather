package training.metofficeweather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Import {
    private Client client = ClientBuilder.newClient();
    private String locationImport;

    public void Import() {
    }
    public String importWholeList(){
        locationImport = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        return locationImport;
    }
    public String importWithLocation(String locationId){
        locationImport = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationId + "?res=3hourly&key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        return locationImport;
    }
}
