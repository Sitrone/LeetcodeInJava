package com.algs4.hw3;

/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
		if (that == null)
			throw new NullPointerException();
		
		if (this.x == that.x && this.y == that.y)
			return Double.NEGATIVE_INFINITY;
		if (this.x == that.x && this.y != that.y)
			return Double.POSITIVE_INFINITY;
		if (this.x != that.x && this.y == that.y)
			return +0.0;
		return (double) (that.y - y) / (that.x - x);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
		if (that == null)
			throw new NullPointerException();
		if (this.y < that.y || (this.y == that.y && this.x < that.x))
			return -1;
		else if (this.x == that.x && this.y == that.y)
			return 0;
		else
			return 1;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder(){
    	return new SlopeOrder();
    }

    private final class SlopeOrder implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2)
		{
			return Double.compare(slopeTo(o1), slopeTo(o2));
		}
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

	private static void verify(boolean invariant)
	{
		if (!invariant)
		{
			System.out.println("*** ERROR:  ");
			Thread.dumpStack();
		}
	}
    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */
		StdDraw.setScale(0, 100);
		Point a = new Point(20, 20);
		Point b = new Point(80, 80);
		Point c = new Point(40, 60);
		Point d = new Point(60, 100);
		StdDraw.setPenColor(StdDraw.RED);
		a.draw();
		b.draw();
		c.draw();
		d.draw();
		a.drawTo(b);
		a.drawTo(d);
		StdDraw.setPenColor(StdDraw.BLUE);
		a.drawTo(c);

		System.out.println("Slope to vertical line");
		verify(a.slopeTo(new Point(a.x, 40)) == Double.POSITIVE_INFINITY);

		System.out.println("Slope to horisontal line");
		verify(a.slopeTo(new Point(40, a.y)) == 0);

		System.out.println("Slope to itself");
		verify(a.slopeTo(a) == Double.NEGATIVE_INFINITY);

		System.out.println("Slope to an arbitrary point");
		verify(a.slopeTo(b) == 1.0);
		verify(a.slopeTo(c) == 2.0);

		System.out.println("Equal slopes");
		verify(a.slopeTo(c) == a.slopeTo(d));
    }
}
