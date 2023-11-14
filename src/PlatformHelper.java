public class PlatformHelper implements Platform{
    public double tilt(double newAngle, Truck truck){
        if (tiltable(truck.getCurrentSpeed())) {
            return Math.min(truck.getMaxAngle(), Math.max(newAngle, truck.getMinAngle()));
        }
    }
    public boolean tiltable(double currentSpeed){
        return currentSpeed == 0;
    }
}
