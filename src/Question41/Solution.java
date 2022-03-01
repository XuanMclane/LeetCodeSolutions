package Question41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] indexNums = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] <= 0) continue;
            int index = Math.abs(nums[i] - 1);
            if (index < nums.length) {
                indexNums[index] = 1;
            }
        }
        for (int i = 0; i< indexNums.length; i++) {
            if (indexNums[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
