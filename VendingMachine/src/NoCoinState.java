public class NoCoinState implements VendingMachineState{

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.setInsertedCoins(coin);
        System.out.println("Coin Inserted balance is "+coin);
        return  machine.getHasCoinState();
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please Insert the coin First");
        return  machine.getNoCoinState();

    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Please Insert the coin and select First");
        return  machine.getNoCoinState();
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println("Item refilling");
        machine.incrementItemCount(quantity);
        return  machine.getNoCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("No coin to return");
        return  machine.getNoCoinState();
    }
}
