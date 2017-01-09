package com.algs4.hw3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints
{
	private LineSegment[] segments;
	
	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points)
	{
		if(points == null)
			throw new NullPointerException();
		if(points.length < 3) 
			return;
		if(hasDuplicate(points))
			throw new IllegalArgumentException();
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		
		Arrays.sort(pointsCopy);
		List<LineSegment> lines = new LinkedList<>();
		for (int p = 0; p < points.length; p++)
		{
			for (int q = p + 1; q < pointsCopy.length; q++)
			{
				for (int r = q + 1; r < pointsCopy.length; r++)
				{
					for (int s = r + 1; s < pointsCopy.length; s++)
					{
						if (isCollinear(pointsCopy[p], pointsCopy[q], pointsCopy[r], pointsCopy[s]))
						{
							lines.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
						}
					}
				}
			}
		}
		segments = lines.toArray(new LineSegment[0]);
	}

	// the number of line segments
	public int numberOfSegments() 
	{
		return segments.length;
	}

	// the line segments
	public LineSegment[] segments() 
	{
		return Arrays.copyOf(segments, segments.length);
	}
	
	private boolean isCollinear(Point p, Point q, Point r, Point s)
	{
		if(p.slopeTo(q) == p.slopeTo(r))
		{
			return p.slopeTo(q) == p.slopeTo(s);
		}
		else
		{
			return false;
		}
	}
	
	private boolean hasDuplicate(Point[] points)
	{
		for(int i = 0; i < points.length - 1; i++)
		{
			if(points[i].equals(points[i + 1]))
			{
				return true;
			}
		}
		return false;
	}

}
