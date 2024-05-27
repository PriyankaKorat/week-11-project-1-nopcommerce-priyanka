package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 * * click on the ‘Login’ link
 * * Enter valid username
 * * Enter valid password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Log out’ text is display
 * 3. verifyTheErrorMessage
 * * click on the ‘Login’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on login link
        driver.findElement(By.linkText("Log in")).click();
        //verify text
        String expectedText = "Welcome, Please Sign In!";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("not redirct on login page", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on login link
        driver.findElement(By.linkText("Log in")).click();
        //enter valid data in email field
        driver.findElement(By.id("Email")).sendKeys("sanganipriyanka8@gmail.com");
        //enter valid password in password field
        driver.findElement(By.id("Password")).sendKeys("Prime@123");
        //Click on login button
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        //Verify text
        String expectedText1 = "Log out";
        String actualText1 = driver.findElement(By.linkText("Log out")).getText();
        Assert.assertEquals("Not login successfully", expectedText1, actualText1);

    }

    @Test
    public void verifyTheErrorMessage() {
        //click on login link
        driver.findElement(By.linkText("Log in")).click();
        //enter inValid data in email field
        driver.findElement(By.id("Email")).sendKeys("sanganipriyanka8@gmal.com");
        //enter InValid password in password field
        driver.findElement(By.id("Password")).sendKeys("Prie@123");
        //Click on login button
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        //Verify text
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.cssSelector(".message-error.validation-summary-errors")).getText(); //xpath --> //div[@class = 'message-error validation-summary-errors']
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
