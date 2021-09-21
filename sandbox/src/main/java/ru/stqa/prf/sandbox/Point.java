package ru.stqa.prf.sandbox;

public class Point {
    public double x, y;
    public double distance2;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public  double distance(Point b) {
        return Math.sqrt(Math.pow(b.x - this.x, 2) + Math.pow(b.y - this.y, 2));

    }

    public double distance2(Point B) {
        double x = this.x - B.x;
        double y = this.y - B.y;
        return distance2 = Math.sqrt(x * x + y * y);
    }
}