package Question49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap();
        for(String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sorted = String.valueOf(chs);
            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList());
            map.get(sorted).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
