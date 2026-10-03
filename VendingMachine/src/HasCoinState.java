public class HasCoinState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.addCoin(coin);
        System.out.println("Coin Inserted balance is "+ machine.getInsertedCoins());
        return  machine.getHasCoinState();
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        if(machine.getInsertedCoins()>= machine.getItemPrice()) {
            System.out.println("Item selected to dispense");

            int change = machine.getInsertedCoins()- machine.getItemPrice();
            if(change>0){
                System.out.println("change returned");
            }
            machine.setInsertedCoins(0);
            return machine.getDispenseState();
        }
        else {
            int needed = machine.getItemPrice() - machine.getInsertedCoins();
            System.out.println("This much coin needed "+ needed);
            return machine.getHasCoinState();
        }

    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("select item First");
        return  machine.getHasCoinState();
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println(" Cannot refill in this state refilling");
        machine.incrementItemCount(quantity);
        return  machine.getHasCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        machine.setInsertedCoins(0);
        System.out.println("Coin returned");
        return  machine.getNoCoinState();
    }
}
