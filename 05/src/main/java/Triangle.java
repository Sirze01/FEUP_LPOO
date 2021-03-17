public class Triangle implements AreaShape {
    double base;
    double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {

        return (base * height) / 2;
    }

    @Override
    public void draw() {
        System.out.println(Triangle.class.toString());
    }
}
