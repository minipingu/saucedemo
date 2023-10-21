package SauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/SauceDemo/cucumber/features/Login",
        glue = "SauceDemo.cucumber.stepDef.Login",
        plugin = {"html:target/HTML_report_Login.html"}
)
public class RunLogin { }
