package com.algs4.hw3;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Client
{

	public static void main(String[] args) throws InterruptedException
	{
		File files = new File("conf/collinear");
		for(File f : files.listFiles())
		{
			if(f.toString().endsWith(".txt"))
			{
				System.out.println(f.getAbsolutePath());
				test(f.getAbsolutePath());
				Thread.sleep(2000);
			}
		}
	}

	private static void test(String filename)
	{
		StdDraw.clear();
	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    
	    In in = new In(filename);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    if(points.length < 3) return;
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    System.out.println(collinear.numberOfSegments());
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}
