public class Kitten
{
    private String owner;
    private String name;
    private int    age;


    public Kitten(String n, String o)
    {
        this.owner = o;
        this.name = n;
        this.age = 0;
    }


    public void setName(String chgName)
    {
        this.name = chgName + " the Feline";
    }


    public String getName()
    {
        return this.name;
    }


    public void setOwner(String chgOwner)
    {
        this.owner = chgOwner;
    }


    public String getOwner()
    {
        return this.owner;
    }


    public int getAge()
    {
        return this.age;
    }


    public void haveBirthday()
    {
        age++;
    }


    public String toString()
    {
        String info =
            this.name + " is " + this.age + " and belongs to " + this.owner;
        return info;
    }
}
