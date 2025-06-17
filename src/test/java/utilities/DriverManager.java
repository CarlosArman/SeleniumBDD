package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void killDriver() {
        Logs.info("TearDown del padre");
        Logs.debug("Matando el driver");
        new WebdriverProvider().get().quit();
    }

    private void buildRemoteDriver() {
    }

    private void buildLocalDriver() {
        final var headlessMode = System.getProperty("headless") != null;
        var browserProperty = System.getProperty("browser");
        if (browserProperty == null) {
            Logs.debug("Asignando default driver a CHROME");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());
        Logs.debug("Inicializando el driver: %s", browser);
        Logs.debug("Headless mode? %b", headlessMode);

        final var driver = switch (browser) {
            case CHROME -> {
                final var chromeOptions = new ChromeOptions();
                if (headlessMode) {
                    chromeOptions.addArguments("--headless=new");
                }
                yield new ChromeDriver(chromeOptions);
            }
            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if (headlessMode) {
                    edgeOptions.addArguments("--headless=new");
                }
                yield new EdgeDriver(edgeOptions);
            }
            case FIREFOX -> {
                final var firefoxOptions = new FirefoxOptions();
                if (headlessMode) {
                    firefoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver(firefoxOptions);
            }
            case SAFARI -> new SafariDriver();

        };

        // Crear objeto de ChromeOptions
        ChromeOptions options = getChromeOptions();

        // Crear Map para almacenar preferencias
//        Map<String, Object> prefs = getStringObjectMap();

        // Establecer preferencias experimentales
//        options.setExperimentalOption("prefs", prefs);


        Logs.debug("Maximizanndo la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando driver al webdriver provider ");
        new WebdriverProvider().set(driver);
    }

    private enum Browser {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }


    private static Map<String, Object> getStringObjectMap() {
        Map<String, Object> prefs = new HashMap<>();

        // Desactivar la alerta de cambio de contraseña
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Desactivar alertas de permisos
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);

        // Desactivar la sugerencia de guardar contraseña
        prefs.put("password_manager_enabled", false);
        return prefs;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Desactivar notificaciones
        options.addArguments("--disable-notifications");

        // Desactivar geolocalización
        options.addArguments("--disable-geolocation");

        // Desactivar la barra de bienvenida de Chrome
        options.addArguments("--disable-infobars");

        // Desactivar la detección de idioma
        options.addArguments("--disable-translate");

        // Desactivar la sugerencia de sincronización de Chrome
        options.addArguments("--disable-sync");

        // Desactivar la sugerencia de extensión
        options.addArguments("--disable-extensions");

        // Desactivar la sugerencia de inicio rápido
        options.addArguments("--disable-features=siteIsolation");

        // Desactivar  las alertas de cookies
        options.addArguments("--disable-cookies");

        // Desactivar las alertas de pop-up:
        options.addArguments("--disable-popup-blocking");

        // Disable Chrome Password Manager
        options.addArguments("--disable-save-password-bubble");

        //   options.addArguments("--headless"); // Ejecutar en segundo plano
        options.addArguments("--disable-gpu"); // Recomendado para mejorar la estabilidad
//        options.addArguments("--window-size=1920,1080"); // Ajustar el tamaño de la ventana
//        options.addArguments("--remote-debugging-port=9222"); // Puerto para depuración

        options.addArguments("--incognito");
        ; // Iniciar en modo incógnito


        return options;
    }
}
