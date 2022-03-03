package Question6;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/zigzag-conversion/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        boolean goingDown = false;
        int currentRow = 0;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows -1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row: rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.convert("PAYPALISHIRING", 3));
    }
}
