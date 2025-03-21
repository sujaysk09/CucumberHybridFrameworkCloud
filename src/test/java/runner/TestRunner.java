package runner;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/resources/features",
		glue={"stepdefinitions","hooks"},
		//tags="@smok",
		//publish=true, -- for publishing report over https://report.cucumber.io
		//dryRun=true,  -- steps will not invoke step definition, when any step is not implemented
		//dryRun=false, -- by default dryRun=false option will be there -- steps will invoke implemented method irrespctive of unimplemented steps
		plugin= {"pretty",
				"html:target/CucumberReports/CucumberReport.html",
				"json:target/CucumberReports/CucumberReport.json",
				"junit:target/CucumberReports/CucumberReport.xml"}
		)
		//tags="@smoke and @register")
public class TestRunner{

}
