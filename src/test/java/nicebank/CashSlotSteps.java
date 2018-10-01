package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import support.KnowsTheDomain;
import transforms.MoneyConverter;
import cucumber.api.PendingException;

public class CashSlotSteps {

    KnowsTheDomain helper;

    public CashSlotSteps (KnowsTheDomain helper){
        this.helper = helper;
    }

    @Then("^(\\$\\d+\\.\\d+) should be dispensed$")
    public void $ShouldBeDispensed(@Transform(MoneyConverter.class) Money amount) throws Throwable {

        Assert.assertEquals("Incorrect amount was dispensed - ", amount, helper.getCashSlot().getContents());
    }

    @Then("^no money is dispensed$")
    public void noMoneyIsDispensed() throws Exception {
        Assert.assertEquals("Incorrect amount was dispensed - ",
                new Money(0,0), helper.getCashSlot().getContents());
    }
}
