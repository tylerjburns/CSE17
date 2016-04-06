package cs2114.minesweeper;

import java.util.Random;

// -------------------------------------------------------------------------
/**
 *  Creates the MineSweeperBoard definition and methods for its operation
 *
 *  @author Tyler
 *  @version Feb 25, 2016
 */
public class MineSweeperBoard
    extends MineSweeperBoardBase
{
    private int                 width;
    private int                 height;
    private int                 numMines;
    private MineSweeperCell[][] board;
    private Random              w = new Random();
    private Random              h = new Random();


    // ----------------------------------------------------------
    /**
     * Create a new MineSweeperBoard object.
     * @param width : number of columns
     * @param height : number of rows
     * @param numMines : number of mines to generate in the board
     */
    public MineSweeperBoard(int width, int height, int numMines)
    {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        board = new MineSweeperCell[width][height];
        for (int i = 0; i < numMines; i++)
        {
            setCell(w.nextInt(width), h.nextInt(height), MineSweeperCell.MINE);
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (board[x][y] != MineSweeperCell.MINE)
                {
                    setCell(x, y, MineSweeperCell.COVERED_CELL);
                }
            }
        }

    }


    @Override
    public int width()
    {
        return width;
    }


    @Override
    public int height()
    {
        return height;
    }


    @Override
    public MineSweeperCell getCell(int x, int y)
    {
        if (x < width && x >= 0 && y < height && y >= 0)
        {
            return board[x][y];
        }
        else
        {
            return MineSweeperCell.INVALID_CELL;
        }

    }


    @Override
    public void uncoverCell(int x, int y)
    {
        if (x < width && x >= 0 && y < height && y >= 0)
        {
            if (this.getCell(x, y) == MineSweeperCell.MINE)
            {
                setCell(x, y, MineSweeperCell.UNCOVERED_MINE);
                isGameLost();
            }

            else if (this.getCell(x, y) == MineSweeperCell.COVERED_CELL)
            {
                setCell(
                    x,
                    y,
                    MineSweeperCell.adjacentTo(numberOfAdjacentMines(x, y)));
            }

        }
    }


    @Override
    public void flagCell(int x, int y)
    {
        if (x < width && x >= 0 && y < height && y >= 0)
        {
            if (this.getCell(x, y) == MineSweeperCell.FLAG)
            {
                setCell(x, y, MineSweeperCell.COVERED_CELL);
            }
            else if (this.getCell(x, y) == MineSweeperCell.FLAGGED_MINE)
            {
                setCell(x, y, MineSweeperCell.MINE);
            }
            else if (this.getCell(x, y) == MineSweeperCell.MINE)
            {
                setCell(x, y, MineSweeperCell.FLAGGED_MINE);
            }
            else if (this.getCell(x, y) == MineSweeperCell.COVERED_CELL)
            {
                setCell(x, y, MineSweeperCell.FLAG);
            }
        }
    }


    @Override
    public boolean isGameLost()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (this.getCell(x, y) == MineSweeperCell.UNCOVERED_MINE)
                {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean isGameWon()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (this.getCell(x, y) == MineSweeperCell.UNCOVERED_MINE
                    || this.getCell(x, y) == MineSweeperCell.FLAG
                    || this.getCell(x, y) == MineSweeperCell.COVERED_CELL
                    || this.getCell(x, y) == MineSweeperCell.MINE)
                {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public int numberOfAdjacentMines(int x, int y)
    {
        int mineCount = 0;
        if (this.getCell(x - 1, y) == MineSweeperCell.MINE
            || this.getCell(x - 1, y) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x - 1, y) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x - 1, y - 1) == MineSweeperCell.MINE
            || this.getCell(x - 1, y - 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x - 1, y - 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x - 1, y + 1) == MineSweeperCell.MINE
            || this.getCell(x - 1, y + 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x - 1, y + 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x, y - 1) == MineSweeperCell.MINE
            || this.getCell(x, y - 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x, y - 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x, y + 1) == MineSweeperCell.MINE
            || this.getCell(x, y + 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x, y + 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x + 1, y) == MineSweeperCell.MINE
            || this.getCell(x + 1, y) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x + 1, y) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x + 1, y + 1) == MineSweeperCell.MINE
            || this.getCell(x + 1, y + 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x + 1, y + 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        if (this.getCell(x + 1, y - 1) == MineSweeperCell.MINE
            || this.getCell(x + 1, y - 1) == MineSweeperCell.FLAGGED_MINE
            || this.getCell(x + 1, y - 1) == MineSweeperCell.UNCOVERED_MINE)
        {
            mineCount++;
        }
        return mineCount;
    }


    @Override
    public void revealBoard()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (this.getCell(x, y) == MineSweeperCell.FLAG
                    || this.getCell(x, y) == MineSweeperCell.COVERED_CELL)
                {
                    board[x][y] =
                        MineSweeperCell.adjacentTo(numberOfAdjacentMines(x, y));
                }
                else if (this.getCell(x, y) == MineSweeperCell.MINE
                    || this.getCell(x, y) == MineSweeperCell.FLAGGED_MINE)
                {
                    setCell(x, y, MineSweeperCell.UNCOVERED_MINE);
                }
            }
        }
    }


    @Override
    protected void setCell(int x, int y, MineSweeperCell value)
    {
        board[x][y] = value;
    }
}
