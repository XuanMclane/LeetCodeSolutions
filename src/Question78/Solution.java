package Question78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList());
        for(int num: nums) {
            List<List<Integer>> temp = new ArrayList();
            for (List<Integer> list : output) {
                temp.add(new ArrayList<>(list){{add(num);}});
            }
            for (List<Integer> list : temp) {
                output.add(list);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.subsets(new int[] {1,2,3}));
    }
}
