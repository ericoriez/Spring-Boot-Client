package org.campus.numerique.client.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LicenseResponse {
    private boolean valide;

    @JsonProperty("valide")
    public boolean isValide() {
        return valide;
    }
    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
