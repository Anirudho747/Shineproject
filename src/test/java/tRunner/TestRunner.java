package tRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"classpath:Login/Lgn1.feature"},
        glue= {"stepDef"},
        monochrome=true,
        plugin = {"html:target/HTML/report.html",
        		  "json:target/Json/report.json",
        		  "junit:target/Junit/report.xml",
        		  "pretty:target/pretty/report.txt"}
                 )
public class TestRunner {

}
