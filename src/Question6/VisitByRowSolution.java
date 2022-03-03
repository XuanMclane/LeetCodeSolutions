package Question6;

//https://leetcode.com/problems/zigzag-conversion/
public class VisitByRowSolution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        StringBuilder ret = new StringBuilder();
        int gap = 2 * numRows - 2;

        for(int i = 0; i< numRows; i++) {
            for (int j = 0; j + i < n; j+= gap) {
                ret.append(s.charAt(i+j));
                if (i != 0 && i != numRows -1 && j + gap - i < n) {
                    ret.append(s.charAt(j + gap - i));
                }
            }
        }
        return ret.toString();
    }
}
