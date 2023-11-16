public abstract class Car extends Vehicle{
    protected boolean inStorage;
    protected Truck storageUnit; // TODO ändra till mer generell typ
    public boolean getInStorage(){return inStorage;}
    public void driveIn(Truck truck){ // TODO mer generell typ
        if (!inStorage){
            inStorage = true;
            storageUnit = truck;
            currentSpeed = 0;
        }
    }
    public void updateStoragePosition(){
        if (inStorage){
            x = storageUnit.getX();
            y = storageUnit.getY();
        }
    }
    @Override
    public void gas(double amount){
        if (!inStorage)
            super.gas(amount);
    }
    @Override
    public void brake(double amount){
        if (!inStorage)
            super.brake(amount);

    }
}
