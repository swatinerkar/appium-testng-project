package pageObjects.webBrowser;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(css = ".wp-block-heading.has-text-align-left")
    private WebElement pageTitle_txt;

    @FindBy(css = "nav[aria-label='Navigation'] button[aria-label='Open menu']")
    private WebElement menu_icon;

    @FindBy(xpath = "//li[@class='has-small-font-size wp-block-navigation-item wp-block-navigation-link']//span[@class='wp-block-navigation-item__label'][normalize-space()='Portfolio']")
    private WebElement portfolio;
    private AndroidDriver driver;
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchWebApp(String webAppUrl) {
        driver.get(webAppUrl);
    }

    public void verifyTheTitleOfPage(String expectedTitle) {
        Assert.assertEquals(pageTitle_txt.getText(), expectedTitle);
    }

    public void clickOpenMenuIcon() {
        menu_icon.click();
    }

    public void clickPortfolioOption() {
        portfolio.click();
    }

    public void scrollTillTextVisible(String text) {
        WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='"+text+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void verifySectionIsDisplayed(String text) {
        Assert.assertTrue(driver.findElement(By.xpath("//strong[normalize-space()='"+text+"']")).isDisplayed());
    }
}
