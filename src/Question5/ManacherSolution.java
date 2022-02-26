package Question5;
//"https://leetcode.com/problems/longest-palindromic-substring/";

public class ManacherSolution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String newStr = modifyString(s);
        int[] p = new int[newStr.length()];

        int center = 0;
        int rightBound = 0;

        for (int i =0; i< newStr.length(); i++) {
            int mirrorIndex = center - (i - center);

            if (i < rightBound) {
                p[i] = Math.min(p[mirrorIndex], rightBound - i);
            }

            int left = i - (p[i] + 1);
            int right = i + (p[i] + 1);
            while(right < newStr.length() && left >=0 && newStr.charAt(right) == newStr.charAt(left)) {
                p[i]++;
                left--;
                right++;
            }

            if (i + p[i] > rightBound) {
                center = i;
                rightBound = i + p[i];
            }
        }

        int maxValueIndex = getMaxValueIndex(p);
        return String.join("", newStr.substring(maxValueIndex - p[maxValueIndex] + 1, maxValueIndex + p[maxValueIndex]).split("#"));
    }

    private String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i=0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }

    private int getMaxValueIndex(int[] s) {
        int maxValue = 0;
        int index = 0;
        for (int i =0; i< s.length; i++) {
            if (maxValue < s[i]) {
                maxValue = s[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ManacherSolution q5 = new ManacherSolution();
        System.out.println(q5.longestPalindrome("abbbadbdcte"));
    }
}
