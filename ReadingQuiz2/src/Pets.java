
public abstract class Pets
{
    private String name;
    private String breed;
    private int age;

    public Pets(String name, String breed){
        age = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public abstract String Move(Pets a);
}
