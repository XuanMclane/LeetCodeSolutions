package Question42;

//https://leetcode.com/problems/trapping-rain-water/solution/
public class Solution {
    public int trap(int[] height) {
        int out = 0;
        int leftMax = 0;
        int[] right = rightMax(height);
        for (int i =0; i<height.length; i++) {
            leftMax = Math.max(height[i], leftMax);
            if (Math.min(leftMax, right[i]) > height[i]) {
                out += Math.min(leftMax, right[i]) - height[i];
            }
        }
        return out;
    }

    private int[] rightMax(int[] height) {
        int max = 0;
        int[] rightMax = new int[height.length];
        for(int i = height.length - 1; i>0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        return rightMax;
    }
}
