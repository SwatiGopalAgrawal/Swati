package testrunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "AllFeatureFiles\\TC_001_SauceDemo.feature" }, glue = { "stepdefination" },

		dryRun = false, plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {
	
	

}
