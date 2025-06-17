package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.CredentialJson;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String credencialesPath =
            "src/test/resources/data/credenciales.json";

    public static CredentialJson obtenerMapCredenciales() {
        final var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(credencialesPath), CredentialJson.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
