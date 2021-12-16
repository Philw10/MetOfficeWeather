package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Param {
    private String name;
    private String units;
    private String $;
}
