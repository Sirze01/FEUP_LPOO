package com.aor.refactoring.example2;

public class Shape {

    private double x;
    private double y;

    protected Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Shape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
    }

    public Shape(double x, double y, double radius) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getArea() throws Exception {
        throw new Exception("Not implemented yet!");
    }

    public double getPerimeter() throws Exception {
        throw new Exception("Not implemented yet!");
    }

    public void draw(GraphicFramework graphics) throws Exception {
        throw new Exception("Not implemented yet!");
    }
}
