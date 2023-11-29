public abstract class Car extends Vehicle implements Storable {
    protected boolean inStorage;
    public boolean getInStorage(){return inStorage;}

    public void driveIn(){
        if (!inStorage){
            inStorage = true;
            stopEngine();
        }
    }
    public void driveOut(double x, double y){
        if (inStorage){
            this.x = x + 3;
            this.y = y;
            inStorage = false;
        }
    }
    public void updateStorage(double x, double y){
        if (inStorage){
            this.x = x;
            this.y = y;
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
