package nicebank;

public class Teller {
    CashSlot cashSlot;
    Display display;
    String message;

    public Teller(CashSlot cashSlot, Display display){
        this.cashSlot = cashSlot;
        this.display = display;
    }

    public boolean withdraw(Account account, Money money) {
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
