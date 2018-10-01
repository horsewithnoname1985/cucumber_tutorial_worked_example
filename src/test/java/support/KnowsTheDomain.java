package support;

import nicebank.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {

    private Account account;
    private CashSlot cashSlot;
    private Teller teller;
    private Display display;
    private EventFiringWebDriver webDriver;


    public Account getAccount() {
        if (account == null) {
            account = new Account();
        }
        return account;
    }

    public Teller getTeller() {
        if (teller == null) {
//            teller = new AtmUserInterface();
            teller = new AutomatedTeller(getCashSlot(), getDisplay());
        }
        return teller;
    }

    public CashSlot getCashSlot() {
        if(cashSlot == null){
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public Display getDisplay() {
        if(display == null){
            display = new Display();
        }
        return display;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null){
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }

        return webDriver;
    }

}
