package SauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SauceDemo/cucumber/features/AddToCart",
        glue = "SauceDemo.cucumber.stepDef.AddToCart",
        plugin = {"html:target/HTML_report_AddToCart.html"}
)
public class RunAddToCart { }
