package nicebank;

public class CashSlot {
    private Money cashSlotMoney;

    public Money dispense(Money money) {
        cashSlotMoney = money;
        return cashSlotMoney;
    }

    public Money getContents() {
        return cashSlotMoney;
    }
}
