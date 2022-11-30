package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/main/resources/Features_File",
            glue = "Step_Definations",
            plugin = { "pretty",
                    "html:target/cucumber.html",
                    "json:target/cucumber.json",
                    "junit:target/cukes.xml",
                    "rerun:target/rerun.txt"},
            dryRun = false
    )


    public class Test_Runner extends AbstractTestNGCucumberTests {

    }