//URL: https://leetcode.com/problems/self-dividing-numbers/

using System.Collections.Generic;

public class SelfDividingNumbers
{
  public IList<int> Solution(int left, int right)
  {
    IList<int> list = new List<int>();
    for (int i = left; i <= right; i++)
    {
      if (isSelfDividing(i))
      {
        list.Add(i);
      }
    }
    return list;
  }

  public bool isSelfDividing(int number)
  {
    int temp = number;
    while (number > 0)
    {
      int divider = number % 10;
      if (divider == 0 || temp % divider != 0)
      {
        return false;
      }
      number /= 10;
    }
    return true;
  }
}