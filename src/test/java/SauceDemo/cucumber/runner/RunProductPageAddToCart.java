package SauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SauceDemo/cucumber/features/ProductPageAddToCart",
        glue = "SauceDemo.cucumber.stepDef.ProductPageAddToCart",
        plugin = {"html:target/HTML_report_ProductPageAddToCart.html"}
)
public class RunProductPageAddToCart { }
