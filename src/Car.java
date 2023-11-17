public abstract class Car extends Vehicle implements Storable {
    protected boolean inStorage;
    protected Truck storageUnit; // TODO ändra till mer generell typ
    public boolean getInStorage(){return inStorage;}
    public void driveIn(Truck truck){ // TODO mer generell typ
        if (!inStorage){
            inStorage = true;
            storageUnit = truck;
            stopEngine();
        }
    }
    public void driveOut(){
        if (inStorage){
            x = storageUnit.getX() + Math.cos(storageUnit.getDirection())*3;
            y = storageUnit.getY() + Math.sin(storageUnit.getDirection())*3;
            inStorage = false;
        }
    }
    public void updateStorage(){
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
