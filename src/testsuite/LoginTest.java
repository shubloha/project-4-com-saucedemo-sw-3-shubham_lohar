package testsuite;

import Utilities.Utility;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {                   //Open browser
        openBrowser(this.baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
       // * Verify the text “PRODUCTS”
        Assert.assertEquals("PRODUCTS", getTextFromElement(By.xpath("//span[text()='Products']")).toUpperCase());                                                                         //Compare 2 strings
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
       //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
       // * Verify that six products are displayed on page
        Assert.assertEquals("User cannot see 6 products.", 6, getMultipleElements(By.className("inventory_item")).size());
    }

    @After
    public void tearDown() {
        //Close browser
        closeBrowser();

    }

}
