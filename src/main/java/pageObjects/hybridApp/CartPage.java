package pageObjects.hybridApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;
import utils.ExplicitlyWait;

import java.util.List;

public class CartPage {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> allItemPrices_txt;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPayablePrice_txt;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms_btn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement termsAlertTitle_txt;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement termsAlertOk_btn;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement sendEmails_chk;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement visitWebSiteToCompletePurchase_btn;

    AndroidDriver driver;
    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public double calculateTotalAmtOfAllItemsPresentInCart() throws InterruptedException {
        //        Sum the prices of all items present under cart and validate it against total amount shown on page
        double totalAmt = 0;
        Thread.sleep(2000);
        ExplicitlyWait.getWait().waitUntilElementVisible(allItemPrices_txt.get(0));
        System.out.println("allItemPrices_txt size: "+allItemPrices_txt.size());
        for(int i=0; i<allItemPrices_txt.size();i++){
            System.out.println(allItemPrices_txt.get(i));
            totalAmt = totalAmt + Double.parseDouble(allItemPrices_txt.get(i).getText().replace("$",""));
        }
        System.out.println("Calculated total amount: "+totalAmt);
        return totalAmt;
    }

    public void verifyTotalWithPayablePricePresentOnPage(double totalAmt) {
        double actualTotalAmt = Double.parseDouble(totalPayablePrice_txt.getText().replace("$", "").trim());
        Assert.assertEquals(actualTotalAmt, totalAmt);
    }

    public void openReadTermsAndConditions() {
        AndroidGestures.getAndroidGesturesObj().longPressWithElement(terms_btn);
    }

    public void verifyTitleOnTermAndConditionsAlert(String expectedTermsAndConditionTitle) {
        String actualTitleOnAlert = termsAlertTitle_txt.getText();
        Assert.assertEquals(actualTitleOnAlert, expectedTermsAndConditionTitle);
    }

    public void clickOkBtnOnTermAlert() {
        termsAlertOk_btn.click();
    }

    public void clickCheckboxSendEmails() {
        sendEmails_chk.click();
    }

    public void clickVisitWebSiteBtn() throws InterruptedException {
        visitWebSiteToCompletePurchase_btn.click();
        Thread.sleep(5000);
    }

}
