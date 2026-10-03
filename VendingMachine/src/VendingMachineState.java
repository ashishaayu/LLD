 public interface VendingMachineState {

    VendingMachineState insertCoin(VendingMachine vendingMachine, int coin);

    VendingMachineState selectItem(VendingMachine vendingMachineState);

    VendingMachineState dispense(VendingMachine vendingMachineState);

    VendingMachineState refill(VendingMachine vendingMachineState, int quantity);

    VendingMachineState returnCoin(VendingMachine vendingMachineState);
}
