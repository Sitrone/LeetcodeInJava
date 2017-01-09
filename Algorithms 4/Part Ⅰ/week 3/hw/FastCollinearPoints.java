package com.algs4.hw3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FastCollinearPoints
{
	private Map<Double, List<Point>> foundSegs = new HashMap<>();
	private List<LineSegment> segments = new LinkedList<>();
	
	// finds all line segments containing 4 points
	public FastCollinearPoints(Point[] points)
	{
		if(points == null)
			throw new NullPointerException();
		if(points.length < 3) 
			return;
		if(hasDuplicate(points))
			throw new IllegalArgumentException();
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		
		for (Point point : pointsCopy)
		{
			Arrays.sort(pointsCopy, point.slopeOrder());
			
			List<Point> slopePoints = new LinkedList<>();
            double slope = 0;
            double previousSlope = Double.NEGATIVE_INFINITY;
			for(int i = 1; i < pointsCopy.length; i++)
			{
				slope = point.slopeTo(pointsCopy[i]);
				if(previousSlope == slope)
				{
					slopePoints.add(pointsCopy[i]);
				}
				else
				{
					if(slopePoints.size() > 3)
					{
						slopePoints.add(point);
						addSegment(slope, slopePoints);
					}
                    slopePoints.clear();
                    slopePoints.add(pointsCopy[i]);
				}
				previousSlope = slope;
			}
			if(slopePoints.size() > 3)
			{
				slopePoints.add(point);
				addSegment(slope, slopePoints);
			}
		}
	}
	
	private void addSegment(Double slope, List<Point> slopePoints)
	{
        List<Point> endPoints = foundSegs.get(slope);
        Collections.sort(slopePoints);

        Point startPoint = slopePoints.get(0);
        Point endPoint = slopePoints.get(slopePoints.size() - 1);

		if (endPoints == null)
		{
			endPoints = new LinkedList<>();
			endPoints.add(endPoint);
			foundSegs.put(slope, endPoints);
			segments.add(new LineSegment(startPoint, endPoint));
		}
		else
		{
			for (Point currentEndPoint : endPoints)
			{
				if (currentEndPoint.compareTo(endPoint) == 0)
				{
					return;
				}
			}
			endPoints.add(endPoint);
			segments.add(new LineSegment(startPoint, endPoint));
		}
	}

	// the number of line segments
	public int numberOfSegments() 
	{
		return segments.size();
	}

	// the line segments
	public LineSegment[] segments() 
	{
		return segments.toArray(new LineSegment[0]);
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
