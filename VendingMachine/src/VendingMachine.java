public class VendingMachine {

    VendingMachineState currentState;
    int itemCount;
    int itemPrice;
    int insertedCoins;

    VendingMachineState noCoinState;
    VendingMachineState hasCoinState;
    VendingMachineState dispenseState;
    VendingMachineState soldOutState;

    public VendingMachine(int itemCount, int itemPrice) {
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.noCoinState = new NoCoinState();
        this.hasCoinState = new HasCoinState();
        this.dispenseState = new DispenseState();
        this.soldOutState = new SoldOutState();

        if(itemCount > 0){
            this.currentState = noCoinState;
        }
        else {
            this.currentState = soldOutState;
        }
    }

    void insetCoin(int coin) {
        currentState = currentState.insertCoin(this, coin);
    }

    void selectItem() {
        currentState = currentState.selectItem(this);
    }

    void dispense() {
        currentState = currentState.dispense(this);

    }

    void refill(int quantity) {
        currentState = currentState.refill(this, quantity);
    }

    void returnCoin() {
        currentState = currentState.returnCoin(this);
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public void setHasCoinState(VendingMachineState hasCoinState) {
        this.hasCoinState = hasCoinState;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public void setNoCoinState(VendingMachineState noCoinState) {
        this.noCoinState = noCoinState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(VendingMachineState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public VendingMachineState getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(VendingMachineState soldOutState) {
        this.soldOutState = soldOutState;
    }

    public void incrementItemCount(int quantity) {
        this.itemCount = this.itemCount+quantity;
    }

    public void addCoin(int coin) {
        this.insertedCoins += coin;
    }

    public void decrementCount() {
        this.itemCount = this.itemCount-1;
    }

    public void printStatus() {
        System.out.println("item remaining :"+itemCount);
        System.out.println("inserted Coin : "+insertedCoins);
        System.out.println("Current State "+currentState.toString());
    }
}
