using System;
using System.Collections.Generic;

public class MostOccuranceChar
{
  public char Solution(string s)
  {
    int[] charArr = new int[256];
    foreach (char c in s.ToCharArray())
    {
      charArr[c]++;
    }
    int max = 0;
    foreach (int i in charArr)
    {
      if (i > max)
      {
        max = i;
      }
    }
    foreach (char c in s.ToCharArray())
    {
      if (charArr[c] == max)
      {
        return c;
      }
    }
    return s[0];
  }
}