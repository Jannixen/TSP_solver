package model;

public class City {

    private final double x;
    private final double y;
    private final int id;

    public City(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
