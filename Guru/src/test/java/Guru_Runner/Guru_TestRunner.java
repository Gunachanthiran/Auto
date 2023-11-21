package Guru_Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Login/gurulogin.feature"}, glue = {"Guru_Definition"}, plugin = {"html:report/gurureport.html"})
public class Guru_TestRunner extends AbstractTestNGCucumberTests {

}
