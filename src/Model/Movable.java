package Model;

public interface Movable {
    void move(int boundX, int boundY);
    void turnLeft(double turnAngle);
    void turnRight(double turnAngle);
}
