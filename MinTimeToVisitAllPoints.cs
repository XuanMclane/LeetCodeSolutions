using System;

public class MinTimeToVisitAllPoints
{
  public int Solution(int[][] points)
  {
    int steps = 0;
    if (points.Length < 2)
    {
      return steps;
    }
    for (int i = 0; i < points.Length - 1; i++)
    {
      int[] start = points[i];
      int[] end = points[i + 1];
      steps += Math.Max(Math.Abs(start[0] - end[0]), Math.Abs(start[1] - end[1]));
    }
    return steps;
  }
}