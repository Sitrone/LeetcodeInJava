package com.cs61b.project2.player;

import static com.cs61b.project2.player.Chip.*;

import com.cs61b.project2.list.DList;
import com.cs61b.project2.list.InvalidNodeException;

public class Board
{
    public final static int DIMENSION = 8;
    
    private int blackChips;
    private int whiteChips;
    
    private Chip[][] grid;
    private DList chipList;
    
    public Board()
    {
        grid = new Chip[DIMENSION][DIMENSION];
        for(int i = 0; i < DIMENSION; i++)
        {
            for(int j = 0; j < DIMENSION; j++)
            {
                grid[i][j] = new Chip(EMPYT, i, j);
            }
        }
        this.blackChips = 0;
        this.whiteChips = 0;
        this.chipList = new DList();
    }
    
    public DList getChipList()
    {
        return this.chipList;
    }
    
    public int getWidth()
    {
        return DIMENSION;
    }
    
    public int getHeight()
    {
        return DIMENSION;
    }
    
    public Chip getChip(int x, int y)
    {
        return grid[x][y];
    }
    
    public void setChip(Chip chip)
    {
        int x = chip.getLocation().getX();
        int y = chip.getLocation().getY();
        grid[x][y] = chip;
        
        if(BLACK == chip.getSide())
        {
            blackChips++;
        }
        else if(WHITE == chip.getSide())
        {
            whiteChips++;
        }
        chipList.insertBack(chip);
    }
    
    public void removeChip(Chip chip) throws InvalidNodeException
    {
        int x = chip.getLocation().getX();
        int y = chip.getLocation().getY();
        if(!grid[x][y].equals(chip)) return;
        
        grid[x][y] = new Chip(EMPYT, x, y);
        if(BLACK == chip.getSide())
        {
            blackChips--;
        }
        else if(WHITE == chip.getSide())
        {
            whiteChips--;
        }
        chipList.remove(chipList.find(chip));
    }
    
    public boolean hasChip(int x, int y)
    {
        if(x < 0 || x > DIMENSION - 1 || y < 0 || y > DIMENSION - 1)
        {
            return false;
        }
        return grid[x][y].getSide() == EMPYT ? true : false;
    }
    
    public boolean hasChip(int x, int y, int side)
    {
        if(x < 0 || x > DIMENSION - 1 || y < 0 || y > DIMENSION - 1)
        {
            return false;
        }
        if(side != BLACK || side != WHITE || side != EMPYT)
        {
            return false;
        }
        return grid[x][y].getSide() == side;
    }
    
    
    public boolean hasValidNetWork(int side)
    {
        switch(side)
        {
        case BLACK:
            // TODO
            return false;
        case WHITE:
            
            return false;
        default:
            throw new IllegalArgumentException("Illegal side :" + side);
        }
    }
    
    
    public Chip[][] getBoard()
    {
        return grid;
    }

    public int getBlackChips()
    {
        return blackChips;
    }

    public int getWhiteChips()
    {
        return whiteChips;
    }
    
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Board is : \n")
          .append("-----------------------------------------");
        
        for(int i = 0; i < DIMENSION; i++)
        {
            for(int j = 0; j < DIMENSION; j++)
            {
                sb.append("| " + grid[i][j]);
            }
            sb.append(" |").append("\n");
            sb.append("-----------------------------------------");
        }
        
        sb.append("\n");
        return sb.toString();
    }
    
}
