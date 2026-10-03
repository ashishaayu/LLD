public class SoldOutState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.setInsertedCoins(coin);
        System.out.println("Please wait Already despensing");
        return  machine.getSoldOutState();
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please wait Already dispensing");
        return  machine.getSoldOutState();

    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {

        if(machine.getItemCount()>0) {
            System.out.println("item dispensed");
            machine.decrementCount();
            return machine.getSoldOutState();
        }
        else {
            System.out.println("item SoldOut");
            return machine.getSoldOutState();
        }
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println("refill in Progress");
        machine.incrementItemCount(quantity);
        return  machine.getNoCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("No coin to return");
        return  machine.getSoldOutState();
    }
}
