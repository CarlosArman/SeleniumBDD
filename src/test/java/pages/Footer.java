package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class Footer extends BasePage {
    private final By twitterButton = By.xpath("//a[text()='Twitter']");
    private final By linkedinButton = By.xpath("//a[text()='LinkedIn']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");

    @Override
    public void waitPageToLoad() {
    }

    @Override
    public void verifyPage() {
    }

    public void verifySocialMediaLinks(String twitterUrl, String linkedinUrl, String facebookUrl) {
        final var twitterLabel = find(twitterButton);
        final var linkedinLabel = find(linkedinButton);
        final var facebookLabel = find(facebookButton);

        Assertions.assertAll(() -> Assertions.assertTrue(twitterLabel.isDisplayed()),
                () -> Assertions.assertTrue(twitterLabel.isEnabled()),
                () -> Assertions.assertEquals(twitterLabel.getDomAttribute("href"), twitterUrl),

                () -> Assertions.assertTrue(linkedinLabel.isDisplayed()),
                () -> Assertions.assertTrue(linkedinLabel.isEnabled()),
                () -> Assertions.assertEquals(linkedinLabel.getDomAttribute("href"), linkedinUrl),

                () -> Assertions.assertTrue(facebookLabel.isDisplayed()),
                () -> Assertions.assertTrue(facebookLabel.isEnabled()),
                () -> Assertions.assertEquals(facebookLabel.getDomAttribute("href"), facebookUrl)
        );
    }
}
