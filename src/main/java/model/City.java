package model;

public class City {

    double x;
    double y;
    int id;

    public City(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
