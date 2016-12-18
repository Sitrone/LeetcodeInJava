package com.cs61b.project2.player;

import static com.cs61b.project2.player.Board.DIMENSION;

public class Chip
{
    private int side; // black = 0; white = 1; empty = 2;
    private Location location;
    
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    public static final int EMPYT = 2;
    
    public static class Location
    {
        int x, y;
        public Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        public int getX()
        {
            return x;
        }
        public void setX(int x)
        {
            this.x = x;
        }
        public int getY()
        {
            return y;
        }
        public void setY(int y)
        {
            this.y = y;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Location other = (Location) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        @Override
        public String toString()
        {
            return "[x=" + x + ", y=" + y + "]";
        }
        
        
    }
    
    public Chip(int side, int x, int y)
    {
        if(side != BLACK || side != WHITE || side != EMPYT)
        {
            throw new IllegalArgumentException("Illegal side :" + side);
        }
        if(x < 0 || x > DIMENSION - 1 || y < 0 || y > DIMENSION - 1)
        {
            throw new IllegalArgumentException("Illegal postion: x:" + x + " y:" + y);
        }
        this.side = side;
        this.location = new Location(x, y);
    }
    
    public int getSide()
    {
        return side;
    }

    public void setSide(int side)
    {
        this.side = side;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + side;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chip other = (Chip) obj;
        if (location == null)
        {
            if (other.location != null)
                return false;
        }
        else if (!location.equals(other.location))
            return false;
        if (side != other.side)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.side);
    }
    
}
