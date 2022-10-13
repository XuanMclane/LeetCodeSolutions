package Question89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return Arrays.asList(0,1);
        }
        List<Integer> list1 = grayCode(n-1);
        List<Integer> list2 = new ArrayList<>(list1);
        int add = (int) Math.pow(2, n-1);
        for (int i = list1.size() -1; i >= 0; i--) {
            list2.add(list1.get(i) + add);
        }
        return list2;
    }
}
