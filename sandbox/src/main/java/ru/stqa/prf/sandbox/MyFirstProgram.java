package ru.stqa.prf.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Square s = new Square(5);
        System.out.println(s.area());
        Rectangle r = new Rectangle(3,4);
        System.out.println(r.area());
        Point a = new Point(2,3);
        Point b = new Point (3,3);
        System.out.println(a.distance2(b));
    }
}