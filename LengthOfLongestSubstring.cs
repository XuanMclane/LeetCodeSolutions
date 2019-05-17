using System;
using System.Collections.Generic;


//URL:https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring 
{
    public int solution(string s) 
    {
        int ans = 0;
        int i = 0;
        int j = 0;
        HashSet<char> charSet = new HashSet<char>();
        int n = s.Length;
        while(i < n && j < n) 
        {
            if(!charSet.Contains(s[j]))
            {
                charSet.Add(s[j]);
                j++;
                ans = Math.Max(ans, j - i);
            }
            else
            {
                charSet.Remove(s[i]);
                i++;
            }
        }
        return ans;
    }
}