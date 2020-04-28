package hellocucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/*
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
*/
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/hellocucumber/newuser.feature"
        //features = "src/test/javaFeatures"
,glue= {"seleniumgluecode"}
)

public class RunCucumberTest {

}


//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
//public class RunCucumberTest {
//}
