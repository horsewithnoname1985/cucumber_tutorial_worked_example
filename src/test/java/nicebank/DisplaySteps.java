package nicebank;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import support.KnowsTheDomain;

public class DisplaySteps {

    KnowsTheDomain helper;

    public DisplaySteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^I am notified about unsufficient balance$")
    public void iAmNotifiedAboutUnsufficientBalance() throws Exception {
//        Assert.assertEquals("Unsufficient balance message is not displayed - ",
//                helper.getTeller().getMessage(), helper.getDisplay().currentMessage);
        Assert.assertEquals("Unsufficient balance message is not displayed - ",
                "Unsufficient Balance. Returning card.", helper.getDisplay().currentMessage);
    }


}
