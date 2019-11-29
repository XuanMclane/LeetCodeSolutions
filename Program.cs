using System;

namespace LeetCodeSolutions
{
  class Program
  {
    static void Main(string[] args)
    {
      SelfDividingNumbers s = new SelfDividingNumbers();
      Console.WriteLine(String.Join(", ", s.Solution(1, 22)));
    }
  }
}
