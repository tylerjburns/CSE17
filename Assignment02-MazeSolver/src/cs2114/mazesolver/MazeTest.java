package cs2114.mazesolver;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for the Maze class.
 *
 * @author Tyler
 * @version Mar 27, 2016
 */
public class MazeTest
    extends TestCase
{
    private Maze      maze1;
    private ILocation zero;
    private ILocation random;
    private ILocation end;
    private MazeCell  testCell;
    private Maze      maze2;
    private ILocation one;
    private ILocation two;
    private ILocation three;
    private ILocation four;
    private ILocation five;
    private ILocation six;
    private Maze      maze3;


    // ----------------------------------------------------------
    /**
     * Setup method for the test class and all test cases.
     */
    public void setUp()
    {
        maze1 = new Maze(5);
        zero = new Location(0, 0);
        random = new Location(3, 4);
        end = new Location(4, 4);
        testCell = MazeCell.valueOf("UNEXPLORED");
        maze2 = new Maze(5);
        one = new Location(1, 0);
        two = new Location(1, 1);
        three = new Location(4, 3);
        four = new Location(0, 1);
        maze3 = new Maze(5);
        five = new Location(1, 2);
        six = new Location(0, 2);
    }


    // ----------------------------------------------------------
    /**
     * Tests to make sure the size is set correctly.
     */
    public void testSize()
    {
        assertEquals(5, maze1.size());
    }


    // ----------------------------------------------------------
    /**
     * Makes sure the get method works for start location.
     */
    public void testGetStartLocation()
    {
        assertEquals(zero, maze1.getStartLocation());
    }


    // ----------------------------------------------------------
    /**
     * Tests the set method for start location by setting it to multiple
     * different things in different situations.
     */
    public void testSetStartLocation()
    {
        maze1.setStartLocation(random);
        assertEquals(random, maze1.getStartLocation());

        maze1.setCell(random, MazeCell.WALL);
        maze1.setStartLocation(random);
        assertEquals(random, maze1.getStartLocation());

        maze1.setCell(random, MazeCell.CURRENT_PATH);
        maze1.setStartLocation(random);
        assertEquals(random, maze1.getStartLocation());

        maze1.setCell(random, MazeCell.FAILED_PATH);
        maze1.setStartLocation(random);
        assertEquals(random, maze1.getStartLocation());

        maze1.setCell(random, testCell);
        maze1.setStartLocation(random);
        assertEquals(random, maze1.getStartLocation());
    }


    // ----------------------------------------------------------
    /**
     * Makes sure the get method works for goal location.
     */
    public void testGetGoalLocation()
    {
        assertEquals(end, maze1.getGoalLocation());
    }


    // ----------------------------------------------------------
    /**
     * Tests the set method for goal location by setting it to multiple
     * different things in different situations.
     */
    public void testSetGoalLocation()
    {
        maze1.setGoalLocation(random);
        assertEquals(random, maze1.getGoalLocation());

        maze1.setCell(random, MazeCell.WALL);
        maze1.setGoalLocation(random);
        assertEquals(random, maze1.getGoalLocation());
    }


    // ----------------------------------------------------------
    /**
     * Tests the get cell method by confirming that a cell is filled with what
     * it should be filled with.
     */
    public void testGetCell()
    {
        maze1.setCell(random, MazeCell.WALL);
        assertEquals(MazeCell.WALL, maze1.getCell(random));
    }


    // ----------------------------------------------------------
    /**
     * Tests the set cell method in multiple situations and setting it equal to
     * multiple things to make sure it operates as it should.
     */
    public void testSetCell()
    {
        maze1.setCell(zero, MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, maze1.getCell(zero));
        maze1.setCell(random, MazeCell.WALL);
        assertEquals(MazeCell.WALL, maze1.getCell(random));
        maze1.setCell(end, MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, maze1.getCell(end));
        maze1.setCell(random, MazeCell.CURRENT_PATH);
        assertEquals(MazeCell.CURRENT_PATH, maze1.getCell(random));
    }


    // ----------------------------------------------------------
    /**
     * Makes sure the solver can solve the maze by giving it multiple mazes to
     * solve and comparing the result to the expected outcome.
     */
    public void testSolve()
    {
        maze1.setCell(random, MazeCell.WALL);
        assertEquals(
            "[(0, 0), (1, 0), (2, 0), (3, 0), (4, 0), "
                + "(4, 1), (4, 2), (4, 3), (4, 4)]",
            maze1.solve());
        maze2.setCell(one, MazeCell.WALL);
        maze2.setCell(two, MazeCell.WALL);
        maze2.setCell(three, MazeCell.WALL);
        assertEquals(
            "[(0, 0), (0, 1), (0, 2), (1, 2), (2, 2), (2, 1), (2, 0), (3, 0), "
                + "(4, 0), (4, 1), (4, 2), (3, 2), (3, 3), (3, 4), (4, 4)]",
            maze2.solve());
        maze2.setCell(four, MazeCell.WALL);
        assertNull(maze2.solve());
        maze3.setCell(two, MazeCell.WALL);
        maze3.setCell(five, MazeCell.WALL);
        maze3.setCell(six, MazeCell.WALL);
        assertEquals(
            "[(0, 0), (1, 0), (2, 0), (3, 0), (4, 0), "
                + "(4, 1), (4, 2), (4, 3), (4, 4)]",
            maze3.solve());
    }
}
