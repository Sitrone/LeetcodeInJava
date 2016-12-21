package com.algs4.hw1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats
{
    private Percolation percolation;
    private double[] threshold;
    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials)
    {
        if (n <= 0 || trials <= 0)
        {
            throw new IllegalArgumentException();
        }
        threshold = new double[trials];
        int openTimes = 0;
        for (int i = 0; i < trials; i++)
        {
            percolation = new Percolation(n);
            while (!percolation.percolates())
            {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);
                
                if (percolation.isOpen(x, y)) continue;
                percolation.open(x, y);
                openTimes++;
            }
            percolation = null;  // handle to null to let gc collect
            threshold[i] = (double) openTimes / (n * n);
            openTimes = 0;
        }
    }
    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(threshold);
    }
    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(threshold);
//        double avg = mean();
//        double sum = 0.0;
//        for (int i = 0; i < threshold.length; i++)
//        {
//            sum += Math.pow((threshold[i] - avg), 2);
//        }
//        return Math.sqrt(sum) / Math.sqrt(threshold.length - 1);
    }
    
    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return mean() - 1.96 * stddev() / Math.sqrt(threshold.length);
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        return mean() + 1.96 * stddev() / Math.sqrt(threshold.length);
    }
    // test client (described below)
    public static void main(String[] args)
    {
        int gridRoot = 64;
        int numberOfSperiments = 150;
        PercolationStats simulation = new PercolationStats(gridRoot, numberOfSperiments);

        StdOut.println("Mean            = "+ simulation.mean());
        StdOut.println("Standard Deviation  = "+ simulation.stddev());
        StdOut.println("95% confidence interval = " + simulation.confidenceLo() + ", " + simulation.confidenceHi());
    }

}
