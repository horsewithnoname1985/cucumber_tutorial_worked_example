import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = "src/test/resources/cash_withdrawal.feature",
        glue = {"nicebank", "hooks"},
        snippets = SnippetType.CAMELCASE,
        dryRun = false
)
public class RunCucumberTest {
}