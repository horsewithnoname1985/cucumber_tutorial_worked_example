package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.*;
import org.junit.Assert;
import support.KnowsTheDomain;
import transforms.MoneyConverter;
import cucumber.api.PendingException;

public class AccountSteps {

    Account account;
    KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper){
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(
            @Transform(MoneyConverter.class) Money amount) throws Throwable {

        account = helper.getAccount();
        account.credit(amount);

    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Exception {
        Assert.assertEquals("Incorrect account balance -", amount, helper.getAccount().getBalance());
    }

}
