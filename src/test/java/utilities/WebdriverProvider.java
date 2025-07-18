package utilities;

import org.openqa.selenium.WebDriver;

public class WebdriverProvider {

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public void set(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static WebDriver get() {
        return threadLocal.get();
    }
}
