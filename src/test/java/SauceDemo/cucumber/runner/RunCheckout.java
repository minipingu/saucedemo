package SauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SauceDemo/cucumber/features/Checkout",
        glue = "SauceDemo.cucumber.stepDef.Checkout",
        plugin = {"html:target/HTML_report_Checkout.html"}
)
public class RunCheckout { }
