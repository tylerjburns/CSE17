public class Snake extends Pets
{

    public Snake(String n, String b, int a)
    {
        super(n, b, a);
    }

    public String Move() {
        String info = this.getName() + " Slithers";
        return info;
    }

}
