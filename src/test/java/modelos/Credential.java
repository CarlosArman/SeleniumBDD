package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credential {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
