package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath = "src/test/resources/screenShoots";
    private final static String pageStructurePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screensShotName) {
        Logs.debug("Tomando screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebdriverProvider().get()).getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screensShotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException e) {
            Logs.error("Error al tener el screenshot: %s", e.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        Logs.debug("Tomando page source");

        final var path = String.format("%s/%s.html", pageStructurePath, fileName);
        try {
            final var file = new File(path);

            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebdriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }
        } catch (IOException e) {
            Logs.error("Error al tener el screenshot: %s", e.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence() {
        try {
            Logs.debug("Borrando las carpetas de evidencias");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageStructurePath));
        } catch (IOException e) {
            Logs.error("Error al borrar la evidencia anterior %s", e.getLocalizedMessage());
        }
    }

    public static void attachScreenshot(Scenario scenario) {
        final var screenshotFile = ((TakesScreenshot) new WebdriverProvider().get()).getScreenshotAs(OutputType.BYTES);

        scenario.attach(
                screenshotFile, "image/png", scenario.getName()
        );
    }

    public static void attachPageSource(Scenario scenario) {
        final var pageSource = new WebdriverProvider().get().getPageSource();
        final var parsedPageSource = Jsoup.parse(pageSource).toString();
        scenario.attach(
                parsedPageSource, "text/plain", scenario.getName()
        );
    }

}
