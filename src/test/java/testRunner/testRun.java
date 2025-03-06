package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features={".//Features//orangeHrm.feature",".//Features//addEmployee.feature"},
		          glue="testDefinitions",
		          monochrome=true,
		          dryRun=false,
		          plugin= {"pretty","html:.//target//cucumber_reports//html_report.html"},
		          tags="@regression"
		        )
public class testRun extends AbstractTestNGCucumberTests{

}
