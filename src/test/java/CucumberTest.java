import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefs"},
        features = "src/test/resources/features",
        tags = "@Regression",
        plugin = {"json:target/cucumber-report/cucumber.json"})
public class CucumberTest {

}
