package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘RegisterTest’
 * class
 * 1. userShouldNavigateToRegisterPageSuccessful
 * ly
 * * click on the ‘Register’ link
 * * Verify the text ‘Register’
 * 2. userSholdRegisterAccountSuccessfully *
 * click on the ‘Register’ link
 * * Select gender radio button
 * * Enter First name
 * * Enter Last name
 * * Select Day Month and Year
 * * Enter Email address
 * * Enter Password
 * * Enter Confirm password
 * * Click on REGISTER button
 * * Verify the text 'Your registration
 * completed’
 */

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Click on register link
        driver.findElement(By.linkText("Register")).click();
        //verify text
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Not redirected to register page", expectedText, actualText);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Click on register link
        driver.findElement(By.linkText("Register")).click();
        //click on gender radio button
        driver.findElement(By.id("gender-female")).click();
        //Enter first name
        driver.findElement(By.id("FirstName")).sendKeys("Priyanka");
        //Enter last name
        driver.findElement(By.id("LastName")).sendKeys("Korat");
        //Enter day,month and year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("15");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("August");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1992");
        //Enter email
        driver.findElement(By.id("Email")).sendKeys("priyakorat123@yopmail.com");
        //Enter password
        driver.findElement(By.id("Password")).sendKeys("Prime1234");
        //Enter confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Prime1234");
        //click on register button
        driver.findElement(By.id("register-button")).click();
        //Verify text
        String expected = "Your registration completed";
        String actual = driver.findElement(By.xpath("//div[@class = 'result']")).getText();
        Assert.assertEquals("not register", expected, actual);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
