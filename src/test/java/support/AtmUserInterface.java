package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Money;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

    private String message;
    private final EventFiringWebDriver webDriver;

    public AtmUserInterface() {
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
    }

    @Override
    public boolean withdrawFrom(Account account, Money money) {
        try {
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(money.dollars()));
            webDriver.findElement(By.id("withdraw")).click();
        } finally {
            webDriver.close();
        }

        return false;
    }

    public String getMessage() {
        return message;
    }
}
