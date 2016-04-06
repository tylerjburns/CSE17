package cs2114.mazesolver;

import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * Implementation of the IMaze class. Handles facets of the maze and eventually
 * solves the maze
 *
 * @author Tyler
 * @version Mar 19, 2016
 */
public class Maze
    implements IMaze
{
    private ILocation    startLocation;
    private ILocation    goalLocation;
    private int          size;
    private MazeCell[][] maze1;


    // ----------------------------------------------------------
    /**
     * Create a new Maze object.
     *
     * @param size
     *            is the size to make the maze
     */
    public Maze(int size)
    {
        this.size = size;
        maze1 = new MazeCell[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                maze1[i][j] = MazeCell.UNEXPLORED;
            }
        }
        startLocation = new Location(0, 0);
        goalLocation = new Location(size - 1, size - 1);
    }


    // ----------------------------------------------------------
    /**
     * Gets the size of the maze. Since mazes are square, the size of the maze
     * is the number of cells in either dimension (width or height).
     *
     * @return the size of the maze
     */
    @Override
    public int size()
    {
        return this.size;
    }


    // ----------------------------------------------------------
    /**
     * Gets the starting location of the maze.
     *
     * @return the starting location in the maze
     */
    @Override
    public ILocation getStartLocation()
    {
        return startLocation;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets the starting location in the maze.
     * </p>
     * <p>
     * This method must check to see if there is a wall at the desired new
     * location for the starting point. If there is, you must destroy the wall.
     * </p>
     *
     * @param location
     *            the new starting location in the maze
     */
    @Override
    public void setStartLocation(ILocation location)
    {
        if (getCell(location).equals(MazeCell.WALL))
        {
            maze1[location.x()][location.y()] = MazeCell.UNEXPLORED;
            startLocation = location;
        }
        startLocation = location;

    }


    // ----------------------------------------------------------
    /**
     * Gets the location of the goal in the maze.
     *
     * @return the location of the goal in the maze
     */
    @Override
    public ILocation getGoalLocation()
    {
        return goalLocation;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets the location of the goal in the maze.
     * </p>
     * <p>
     * This method must check to see if there is a wall at the desired new
     * location for the goal. If there is, you must destroy the wall.
     * </p>
     *
     * @param location
     *            the new location of the goal in the maze
     */
    @Override
    public void setGoalLocation(ILocation location)
    {
        if (getCell(location).equals(MazeCell.WALL))
        {
            maze1[location.x()][location.y()] = MazeCell.UNEXPLORED;
            goalLocation = location;
        }
        goalLocation = location;
    }


    // ----------------------------------------------------------
    /**
     * Gets the type of cell at the specified location in the maze. If the
     * location is outside the bounds of the maze, then you must return
     * {@link MazeCell#INVALID_CELL}. Under no circumstances should this method
     * ever throw an exception.
     *
     * @param location
     *            the location to check
     * @return a value from the {@link MazeCell} enumerated type that indicates
     *         the type of cell at that location
     */
    @Override
    public MazeCell getCell(ILocation location)
    {
        try
        {
            return maze1[location.x()][location.y()];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return MazeCell.INVALID_CELL;
        }
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets a location in the maze to be the specified cell type.
     * </p>
     * <p>
     * There is one special condition that this method must check for: if the
     * cell type is {@link MazeCell#WALL} and the location is either the
     * starting location or the goal location, then this method must
     * <strong>ignore the request and change nothing.</strong>
     * </p>
     * <p>
     * Under no circumstances should this method throw an exception,
     * {@code IndexOutOfBounds} or otherwise. If the location given is outside
     * the bounds of the maze, then do nothing.
     * </p>
     *
     * @param location
     *            the location where the wall should be placed
     * @param cell
     *            the cell to set location equal to
     */
    @Override
    public void setCell(ILocation location, MazeCell cell)
    {
        if ((cell.equals(MazeCell.WALL) && (!location.equals(startLocation)
            && !location.equals(goalLocation))) || !cell.equals(MazeCell.WALL))
        {
            maze1[location.x()][location.y()] = cell;
        }
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Tries to find a solution to the maze. If a solution is found, it should
     * be returned as a string that contains the coordinates of each cell in a
     * path that starts at the maze's starting point and leads to the goal,
     * formatted like this (spacing doesn't matter):
     * </p>
     *
     * <pre>
     * (0, 0) (0, 1) (1, 1) (2, 1) (2, 2)
     * </pre>
     * <p>
     * If the maze has no solution, this method should return null.
     * </p>
     * <p>
     * (If the maze has more than one possible solution, you may return any of
     * them.)
     * </p>
     *
     * @return a string representing a solution path if one exists, or null if
     *         there is no solution
     */
    @Override
    public String solve()
    {
        Stack<ILocation> solver = new Stack<ILocation>();
        solver.push(startLocation);
        while (!solver.empty())
        {
            ILocation currentCell = solver.peek();
            setCell(currentCell, MazeCell.CURRENT_PATH);
            if (currentCell.equals(goalLocation))
            {
                String solved = solver.toString();
                return solved;
            }
            else if (getCell(currentCell.north()) == MazeCell.UNEXPLORED
                || getCell(currentCell.east()) == MazeCell.UNEXPLORED
                || getCell(currentCell.south()) == MazeCell.UNEXPLORED
                || getCell(currentCell.west()) == MazeCell.UNEXPLORED)
            {
                if (getCell(currentCell.north()) == MazeCell.UNEXPLORED)
                {
                    currentCell = currentCell.north();
                    solver.push(currentCell);
                }
                else if (getCell(currentCell.east()) == MazeCell.UNEXPLORED)
                {
                    currentCell = currentCell.east();
                    solver.push(currentCell);
                }
                else if (getCell(currentCell.south()) == MazeCell.UNEXPLORED)
                {
                    currentCell = currentCell.south();
                    solver.push(currentCell);
                }
                else if (getCell(currentCell.west()) == MazeCell.UNEXPLORED)
                {
                    currentCell = currentCell.west();
                    solver.push(currentCell);
                }
            }
            else
            {
                setCell(currentCell, MazeCell.FAILED_PATH);
                solver.pop();
            }
        }
        return null;

    }

}
