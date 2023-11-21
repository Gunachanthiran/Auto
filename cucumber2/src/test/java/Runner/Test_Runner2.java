package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class) //run the cucumber class

@CucumberOptions(features = {"src/test/resources/Login/login1.feature"}, dryRun = false, glue = {"definition2"}, plugin = {"html:report/myreport.html"}, tags = "@PossitiveTesting")
public class Test_Runner2 {

}
