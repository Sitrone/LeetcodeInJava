package com.cs61b.project1;

public class Pixel
{
    short red;
    short green;
    short blue;

    public Pixel()
    {
        this((short)0, (short)0, (short)0);
    }
    
    public Pixel(Pixel pixel)
    {
        this(pixel.red, pixel.green, pixel.blue);
    }
    
    public Pixel(short red, short green, short blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public Pixel multiply(short x)
    {
        Pixel res = new Pixel();
        res.red = (short) (x * red);
        res.blue = (short) (x * blue);
        res.green = (short) (x * green);
        return res;
    }
    
    public int squareSum()
    {
        return red * red + blue * blue + green * green;
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
        Pixel other = (Pixel) obj;
        if (blue != other.blue)
            return false;
        if (green != other.green)
            return false;
        if (red != other.red)
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + blue;
        result = prime * result + green;
        result = prime * result + red;
        return result;
    }

    @Override
    public String toString()
    {
        return "[red=" + red + ", green=" + green + ", blue=" + blue + "]";
    }
}
