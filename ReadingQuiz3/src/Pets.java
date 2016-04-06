public abstract class Pets implements Motion
{
    private String name;
    private String breed;
    private int age;

    public Pets(String n, String b, int a) {
        this.name = n;
        this.breed = b;
        this.age = a;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setBreed(String b) {
        this.breed = b;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public int getAge() {
        return this.age;
    }

    public abstract String Move();

}
