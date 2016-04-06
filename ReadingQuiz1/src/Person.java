public class Person
{

    private int    age;

    private String name;


    public Person(String n, int a)
    {
        this.age = a;
        this.name = n;
    }


    public String getName()
    {
        return this.name;
    }


    public int getAge()
    {
        return this.age;
    }


    public void setName(String nam)
    {
        this.name = nam;
    }


    public void setAge(int ag)
    {
        this.age = ag;
    }


    public void speak()
    {
        System.out.println(name);
    }
}
