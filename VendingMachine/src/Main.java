//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int itemCount = 2;
        int itemPrice = 20;

        VendingMachine vendingMachine = new VendingMachine(itemCount,itemPrice);
        vendingMachine.printStatus();
        vendingMachine.insetCoin(20);
        vendingMachine.printStatus();
        vendingMachine.selectItem();
        vendingMachine.printStatus();
        vendingMachine.dispense();
        vendingMachine.printStatus();

    }
}