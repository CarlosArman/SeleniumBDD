package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CredentialJson {
    @JsonProperty("credentials")
    private Map<String, Credential> mapCredenciales;

    public Map<String, Credential> getMapCredenciales() {
        return mapCredenciales;
    }
}
