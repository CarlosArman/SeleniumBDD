package data;

import modelos.Credential;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credential> obtenerMapCredenciales() {
        return JsonReader.obtenerMapCredenciales().getMapCredenciales();
    }

    public static Credential getValidCredentials() {
        return obtenerMapCredenciales().get("valid");
    }

    public static Credential getLockedCredentials() {
        return obtenerMapCredenciales().get("locked");
    }

    public static Credential getUnexistentCredentials() {
        return obtenerMapCredenciales().get("unexistent");
    }
}
