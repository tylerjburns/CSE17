
public class Kitten extends Pets {
    public Kitten(String name, String breed)
    {
        super(name, breed);
    }

    private String moveType = "Runs";

    public String Move(Pets a) {
        String info = a.getName() + this.moveType;
        return info;
    }
}
