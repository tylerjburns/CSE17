public class Point2D extends Point1D {

    protected int y;


    public Point2D(){

        super();

        this.x=0;

    }

    public void setY(int y){

        this.y=y;

    }

    public int getY(){

        return this.y=y;

    }

    public  void display() {

        System.out.println(this.x + "," + this.y);
        Point1D a = new Point2D();
        System.out.println("Z = " + ((Point2D)a).getY());

    }

}