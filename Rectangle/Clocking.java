import java.util.Arrays;

public class Clocking
{
    public static void main(String [] args)
    {
        for (int x = 0; x<10; x++)
        {
            long time1 = System.currentTimeMillis();
            double[] array = new double[10000000];
            for (int i = 0; i<array.length-1; i++)
            {
                array[i] = Math.random();
            }
            Arrays.sort(array);
            System.out.println((System.currentTimeMillis() - time1) + "ms");
        }
        System.out.print("Done");
    }
}
