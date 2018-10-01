package nicebank;

public class AutomatedTeller implements Teller{
    CashSlot cashSlot;
    Display display;
    String message;

    public AutomatedTeller(CashSlot cashSlot, Display display){
        this.cashSlot = cashSlot;
        this.display = display;
    }

    public boolean withdrawFrom(Account account, Money money) {
        Money savings = account.getBalance();
        boolean balanceOK = checkBalance(savings, money);
        if (balanceOK) {
            cashSlot.dispense(money);
            account.debit(money);
            return true;
        } else {
            cashSlot.dispense(new Money(0,0));
            message = "Unsufficient Balance. Returning card.";
            display.displayMessage(message);
            return false;
        }

    }

    public boolean checkBalance(Money savings, Money withdrawAmount) {
        if (savings.dollars()>= withdrawAmount.dollars()){
            if (savings.dollars() == withdrawAmount.dollars()) {
                if(savings.cents() >= withdrawAmount.cents()) {
                    cashSlot.dispense(withdrawAmount);
                } else {
                    return false;
                }
            } else {
                return true;
            }
            return true;
        } else {
            return false;
        }
    }
}
