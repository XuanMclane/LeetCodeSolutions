package Question3;//"https://leetcode.com/problems/longest-substring-without-repeating-characters/";
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (set.add(s.charAt(j))) {
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution q3 = new Solution();
        System.out.println(q3.lengthOfLongestSubstring("abcabcbb"));
    }
}
