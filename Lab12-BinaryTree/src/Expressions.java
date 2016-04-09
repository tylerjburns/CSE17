// -------------------------------------------------------------------------
/**
 * This class utilizes the BinaryTree class to construct an expression tree for
 * a given expression.
 *
 * @author Tyler
 * @version Apr 9, 2016
 */
public class Expressions
{
    // ----------------------------------------------------------
    /**
     * This main method calls the create method and prints all 3 print orders.
     *
     * @param args
     *            This is a parameter of main methods
     */
    public static void main(String[] args)
    {
        BinaryTree<String> expressTreeA =
            new BinaryTree<String>("a");
        BinaryTree<String> expressTreeB =
            new BinaryTree<String>("b");
        BinaryTree<String> expressTreeC =
            new BinaryTree<String>("c");
        BinaryTree<String> expressTreeD =
            new BinaryTree<String>("d");
        BinaryTree<String> expressTreeE =
            new BinaryTree<String>("e");
        BinaryTree<String> expressTreeM =
            new BinaryTree<String>("-");
        BinaryTree<String> expressTreeS =
            new BinaryTree<String>("*");
        BinaryTree<String> expressTreeP =
            new BinaryTree<String>("+");
        BinaryTree<String> expressTreeN =
            new BinaryTree<String>("/");

        // right side of the root
        expressTreeP.setLeft(expressTreeC);
        expressTreeP.setRight(expressTreeD);
        expressTreeN.setLeft(expressTreeP);
        expressTreeN.setRight(expressTreeE);

        // left side of the root
        expressTreeM.setLeft(expressTreeA);
        expressTreeM.setRight(expressTreeB);

        // root connections
        expressTreeS.setLeft(expressTreeM);
        expressTreeS.setRight(expressTreeN);

        System.out.println(expressTreeS.toPreOrderString());
        System.out.println(expressTreeS.toInOrderString());
        System.out.println(expressTreeS.toPostOrderString());
    }
}
