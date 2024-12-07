package org.example;

import jakarta.persistence.Entity;

@Entity
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle() {}

    public Triangle(double base, double height, Color color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        double side = Math.sqrt((base / 2) * (base / 2) + height * height);
        return 2 * side + base;
    }
}
