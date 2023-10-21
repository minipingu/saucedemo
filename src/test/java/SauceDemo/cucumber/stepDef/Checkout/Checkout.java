package SauceDemo.cucumber.stepDef.Checkout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Checkout {
    //set driver fir test using webdriver from selenium
    WebDriver driver;
    //set base url
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user login using valid credential")
    public void user_is_on_SauceDemo_login_page(){
        //setup firefox driver automatically using web driver manager
        WebDriverManager.firefoxdriver().setup();
        //create object to setup option for firefox driver
        FirefoxOptions opt = new FirefoxOptions();
        //set firefox driver to not using headless mode
        opt.setHeadless(false);
        //apply firefox driversetup to driver
        driver = new FirefoxDriver(opt);
        //set timeout for web driver on waiting element
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //access base url
        driver.get(baseUrl);
        //fill username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //fill password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @When("user click one of product")
    public void userClickProduct() {
        driver.findElement(By.className("inventory_item_img")).click();
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }

    @Then("user user click cart icon")
    public void userClickAddToCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("user user click checkout")
    public void userUserClickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user filling (.*) as firstname (.*) as lastname (.*) as zipcode (.*)$")
    public void userFillingFieldFirstnameLastnameZipcodeCanTContinueIfOneOfFieldAreEmpty(
            String username,
            String password,
            String zipcode,
            String field
    ) {
        if (field.equals("filled")) {
            System.out.println(field);
            driver.findElement(By.id("first-name")).sendKeys(username);
            System.out.println("done isi username");
            driver.findElement(By.id("last-name")).sendKeys(password);
            System.out.println("done isi password");
            driver.findElement(By.name("postalCode")).sendKeys(zipcode);
            System.out.println("done isi zipcode");


        } else {
            System.out.println(field);
            driver.findElement(By.id("first-name")).sendKeys(username);
            System.out.println("done isi username");

            driver.findElement(By.id("last-name")).sendKeys(password);
            System.out.println("done isi password");


        } //else

    }

    @Then("can't continue and cant finish checkout if one of (.*) are empty$")
    public void canTContinueAndCantFinishCheckoutIfOneOfFieldAreEmpty(String field) {
        if (field.equals("filled")) {
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            //assert success
            String success = driver.findElement(By.xpath("//h2")).getText();
            System.out.println(success);
            Assert.assertEquals(success, "Thank you for your order!");
            driver.close();

        } else {
            driver.findElement(By.id("continue")).click();
            //assert error
            String error = driver.findElement(By.xpath("//h3")).getText();
            System.out.println(error);
            Assert.assertEquals(error, "Error: Postal Code is required");
            driver.close();
        } //else
    }
}


