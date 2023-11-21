package Neg_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Guru_Neg/guru_negative.feature"}, glue = {"Guru_NegDefinition"}, plugin = {"html:report/gurunegreport.html"}, tags = "@NegativeTesting")
public class Guru_Neg_TestRunner extends AbstractTestNGCucumberTests {

}
