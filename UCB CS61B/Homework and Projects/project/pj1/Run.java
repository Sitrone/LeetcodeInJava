package com.cs61b.project1;

public class Run
{
    private int number;
    private Pixel pixel = new Pixel();
    
    public Run()
    {
        this(-1, (short)-1, (short)-1, (short)-1);
    }
    
    public Run(int number, Pixel pixel)
    {
        this(number, pixel.red, pixel.green, pixel.blue);
    }
    
    public Run(int number, short red, short green, short blue)
    {
        this.pixel.red = red;
        this.pixel.green = green;
        this.pixel.blue = blue;
        this.number = number;
    }

    public int[] getRun()
    {
        int[] thisRun = new int[4];
        thisRun[0] = this.number;
        thisRun[1] = this.pixel.red;
        thisRun[2] = this.pixel.green;
        thisRun[3] = this.pixel.blue;
        return thisRun;
    }
    
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
    
    public Pixel getPixel()
    {
        return pixel;
    }

    public void setPixel(Pixel pixel)
    {
        this.pixel = pixel;
    }

    @Override
    public String toString()
    {
        return "Run [number=" + number + ", pixel=" + pixel + "]";
    }
}
