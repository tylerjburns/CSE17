
public class Eagle extends Pets {
    public Eagle(String name, String breed)
    {
        super(name, breed);
    }

    private String moveType = "Flies";

    public String Move(Pets a) {
        String info = a.getName() + this.moveType;
        return info;
    }
}
