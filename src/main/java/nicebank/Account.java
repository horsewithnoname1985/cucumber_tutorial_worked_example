package nicebank;

public class Account {
    private Money balance = new Money();

    public void credit(Money money) {
        balance = balance.add(money);
    }

    public void debit(Money money) {
        balance = balance.minus(money);
    }

    public Money getBalance() {
        return balance;
    }

}
