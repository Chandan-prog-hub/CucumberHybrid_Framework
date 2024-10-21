package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                         publish=true,
                  glue= {"stepDefinations", "hooks"},
                 plugin={"pretty", "html:target/creports/cucumberreport.html" } )
public class TestMyRunner {
	
	

}