package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class TellerSteps {

    KnowsTheDomain helper;

    public TellerSteps (KnowsTheDomain helper){
        this.helper = helper;
    }

    @When("^I withdraw (\\$\\d+\\.\\d+)$")
    public void iWithdraw$(@Transform(MoneyConverter.class) Money amount) throws Throwable {

        Boolean balanceSufficient;
        Money beforeWithdraw = helper.getAccount().getBalance();
        balanceSufficient = helper.getTeller().withdrawFrom(helper.getAccount(), amount);

        if (balanceSufficient) {
            Assert.assertEquals("Incorrect amount was withdrawn - ",
                    beforeWithdraw.minus(amount), helper.getAccount().getBalance());
        } else {
            Assert.assertEquals("Cannot withdrawFrom more than current balance - ",
                    beforeWithdraw, helper.getAccount().getBalance());
        }

    }
}
