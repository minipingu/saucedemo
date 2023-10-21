package SauceDemo.cucumber.stepDef.AddToCart;

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

public class AddToCart {
    //set driver fir test using webdriver from selenium
    WebDriver driver;

    //set base url
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on SauceDemo login page")
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
    }

    @When("user input (.*) as email$")
    public void user_input_tdd_selenium_gmail_com_as_email(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @And("user click (.*) add to cart or remove$")
    public void userClickButtonAddToCartOrRemove(String button) {
        if(button.equals("Remove")){
            driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        } else {
            driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Then("user verify (.*) added or removed$")
    public void userVerifyShopping_cart_badgeAddedOrRemoved(String shopping_cart_badge) {
        if (shopping_cart_badge.equals("added")) {
            //assert success login
            String added = driver.findElement(By.className("shopping_cart_badge")).getText();
            Assert.assertEquals(added, "1");
            driver.close();

        } else {
            //assert error message
            String empty = driver.findElement(By.className("shopping_cart_link")).getText();
            Assert.assertEquals(empty, "");
            driver.close();

        } //else
    }

}
