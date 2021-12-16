package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rep {

    public String D; //Wind direction
    public String F; //Feels like
    public String G; //Wind gust
    public String H; //Relative humidity
    public String Pp; //Precipitation probability
    public String S; //Wind speed
    public String T; //Temperature
    public String V; //Visibility
    public String W; //Weather type
    public String U; //Max UV
    public String $;

    public String getD() {
        return D;
    }

    public String getF() {
        return F;
    }

    public String getG() {
        return G;
    }

    public String getH() {
        return H;
    }

    public String getPp() {
        return Pp;
    }

    public String getS() {
        return S;
    }

    public String getT() {
        return T;
    }

    public String getV() {
        return V;
    }

    public String getW() {
        return W;
    }

    public String getU() {
        return U;
    }

    public String get$() {
        return $;
    }
}
