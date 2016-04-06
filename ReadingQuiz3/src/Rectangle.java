public class Rectangle implements Shape
{
    private double width;
    private double length;

    public Rectangle() {
        this.width = 0;
        this.length = 0;
    }

    public Rectangle(double w, double l) {
        this.width = w;
        this.length = l;
    }


    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double Area()
    {
        double area = this.getLength() * this.getWidth();
        return area;
    }

    public double Perimeter()
    {
        double perimeter = (this.getLength()*2)+(this.getWidth()*2);
        return perimeter;
    }


}
