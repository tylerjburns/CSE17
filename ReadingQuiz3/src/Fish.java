public class Fish extends Pets
{

   public Fish(String n, String b, int a)
   {
       super(n, b, a);
   }

   public String Move() {
       String info = this.getName() + " Swims";
       return info;
   }
}
