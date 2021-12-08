package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Period {
    public String D;
    public String F;
    public String G;
    public String H;
    public String Pp;
    public String S;
    public String T;
    public String V;
    public String W;
    public String U;
    public String $;

    @Override
    public String toString() {
        return "Forecast{" +
                "D='" + D + '\'' +
                ", F='" + F + '\'' +
                ", G='" + G + '\'' +
                ", H='" + H + '\'' +
                ", Pp='" + Pp + '\'' +
                ", S='" + S + '\'' +
                ", T='" + T + '\'' +
                ", V='" + V + '\'' +
                ", W='" + W + '\'' +
                ", U='" + U + '\'' +
                ", $='" + $ + '\'' +
                '}';
    }
}
