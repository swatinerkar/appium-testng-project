package pageObjects.hybridApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

public class LoginFormPage{
        AndroidDriver driver;

        @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
        private WebElement countryDropdown;

        @AndroidFindBy(xpath = "//android.widget.Toast")
        private WebElement toastMsg_txt;

        @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
        private WebElement name_txt;

        @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
        private WebElement female_radio;

        @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
        private WebElement male_radio;

        @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
        private WebElement letsShop_btn;
        public LoginFormPage(AndroidDriver driver) {
                this.driver = driver;
                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        public void clickCountryDropDown() throws InterruptedException {
                countryDropdown.click();
        }

        public void selectCountry(String country) throws InterruptedException {
                AndroidGestures.getAndroidGesturesObj().scrollTillTextVisible(country);
                driver.findElement(By.xpath("//android.widget.TextView[@text=\""+country+"\"]")).click();
        }

        public void enterName(String name) {
                name_txt.sendKeys(name);
                driver.hideKeyboard();      //To hide the keyboard
        }

        public void selectGender(String gender)
        {
                if(gender.equalsIgnoreCase("female"))
                        female_radio.click();

                else if (gender.equalsIgnoreCase("male"))
                        male_radio.click();
        }

        public void clickLetsShopBtn() {
                letsShop_btn.click();
        }

        public void verifyToastMsg(String expectedToastMsg) {
                Assert.assertEquals(toastMsg_txt.getAttribute("name"), expectedToastMsg);
        }
}

