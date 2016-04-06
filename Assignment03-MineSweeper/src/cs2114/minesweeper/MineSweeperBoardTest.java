package cs2114.minesweeper;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  This class tests all of the methods
 *  in the MineSweeperBoard class
 *
 *  @author Tyler
 *  @version Feb 25, 2016
 */
public class MineSweeperBoardTest
    extends TestCase
{
    /**
     * Instance of MineSweeperBoard
     */
    MineSweeperBoard a;

    /**
     * Set up method that is called before each test method
     */
    public void setUp()
    {
        a = new MineSweeperBoard(4, 4, 3);
    }


    // ----------------------------------------------------------
    /**
     * Asserts that the width is set to the correct value after constructing
     * the MineSweeperBoard object
     */
    public void testWidth()
    {
        assertEquals(4, a.width());
    }


    // ----------------------------------------------------------
    /**
     * Asserts that the height is set to the correct value after constructing
     * the MineSweeperBoard object
     */
    public void testHeight()
    {
        assertEquals(4, a.height());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getCell() method by calling it on known value cells
     */
    public void testGetCell()
    {
        a.loadBoardState("OOOO", "OO+O", "O+OO", "+OOO");
        assertEquals(MineSweeperCell.COVERED_CELL, a.getCell(0, 0));
        assertEquals(MineSweeperCell.MINE, a.getCell(1, 2));
    }


    // ----------------------------------------------------------
    /**
     * Uncovers the cells in a known array and compares them to the expected
     * values
     */
    public void testUncoverCell()
    {
        a.loadBoardState("OFMO",
                         "OO+O",
                         "O+OO",
                         "+OOO");

        a.uncoverCell(2, 2);
        assertEquals(MineSweeperCell.ADJACENT_TO_2, a.getCell(2, 2));
    }


    // ----------------------------------------------------------
    /**
     * Tests the flag cell method by flagging a known cell and then checking
     * its value
     */
    public void testFlagCell()
    {

        a.loadBoardState("OOOF", "OOMO", "O+OO", "+OOO");

        a.flagCell(0, 0);
        assertEquals(MineSweeperCell.FLAG, a.getCell(0, 0));
        a.flagCell(3, 0);
        assertEquals(MineSweeperCell.COVERED_CELL, a.getCell(3, 0));
        a.flagCell(0, 3);
        assertEquals(MineSweeperCell.FLAGGED_MINE, a.getCell(0, 3));
        a.flagCell(2, 1);
        assertEquals(MineSweeperCell.MINE, a.getCell(2, 1));

    }


    // ----------------------------------------------------------
    /**
     * Checks if game is won using a board state that is not completely
     * uncovered and then with one that is completely uncovered
     * and asserts their "won" states
     */
    public void testIsGameWon()
    {

        a.loadBoardState("221 ", "MM1 ", "2321", " 1MF");

        assertEquals(false, a.isGameWon());

        a.loadBoardState("221 ", "MM1 ", "2321", " 1M*");

        assertEquals(false, a.isGameWon());

        a.loadBoardState("221 ", "MM1 ", "2321", " 1M+");

        assertEquals(false, a.isGameWon());

        a.loadBoardState("221 ", "MM1 ", "2321", " 1MO");

        assertEquals(false, a.isGameWon());

        a.uncoverCell(3, 3);

        assertEquals(true, a.isGameWon());
    }


    // ----------------------------------------------------------
    /**
     * Using a board with an uncovered mine signifier, calls to check
     * if the game is lost, expecting a true return
     */
    public void testIsGameLost()
    {
        a.loadBoardState("OOOO", "OO+O", "O+OO", "+OOO");
        assertEquals(false, a.isGameLost());
        a.uncoverCell(2, 1);
        assertEquals(MineSweeperCell.UNCOVERED_MINE, a.getCell(2, 1));
        assertEquals(true, a.isGameLost());

    }


    // ----------------------------------------------------------
    /**
     * Using multiple board states, checks each state for correct num mines
     */
    public void testNumberOfAdjacentMines()
    {

        a.loadBoardState("+++O",
                         "+O+O",
                         "+++O",
                         "+O+O");

        assertEquals(8, a.numberOfAdjacentMines(1, 1));
        assertEquals(5, a.numberOfAdjacentMines(1, 3));
        assertEquals(2, a.numberOfAdjacentMines(3, 3));
        assertEquals(3, a.numberOfAdjacentMines(3, 2));

        a.loadBoardState("+++O",
                         "+O+O",
                         "++OO",
                         "OOOO");

        assertEquals(0, a.numberOfAdjacentMines(3, 3));
        assertEquals(1, a.numberOfAdjacentMines(3, 2));
        assertEquals(7, a.numberOfAdjacentMines(1, 1));

        a.loadBoardState("+++O",
                         "+OOO",
                         "O++O",
                         "OOOO");

        assertEquals(4, a.numberOfAdjacentMines(2, 1));
        assertEquals(6, a.numberOfAdjacentMines(1, 1));
    }


    // ----------------------------------------------------------
    /**
     * Asserts that two boards are equivalent to each other
     * Helper method for test case
     * @param theBoard : first board, board to be tested
     * @param expected : board tested board is expected to match
     */
    public void assertBoard(MineSweeperBoard theBoard, String... expected)
    {
        MineSweeperBoard expectedBoard =
            new MineSweeperBoard(expected[0].length(), expected.length, 0);
        expectedBoard.loadBoardState(expected);
        assertEquals(expectedBoard, theBoard); // uses equals() from
                                               // MineSweeperBoardBase
    }


    // ----------------------------------------------------------
    /**
     * Reveals every single cell in a whole board and then makes sure all
     * of it is correct
     */
    public void testRevealBoard()
    {
        a.loadBoardState("+++O",
                         "+OOO",
                         "O++O",
                         "OOOO");

        a.revealBoard();

        assertBoard(a, "***1",
                       "*642",
                       "2**1",
                       "1221");

    }
}
