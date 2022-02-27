package Question17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private static HashMap<String, List<String>> LETTERS = new HashMap();

    static {
        LETTERS.put("2", List.of("a", "b", "c"));
        LETTERS.put("3", List.of("d", "e", "f"));
        LETTERS.put("4", List.of("g", "h", "i"));
        LETTERS.put("5", List.of("j", "k", "l"));
        LETTERS.put("6", List.of("m", "n", "o"));
        LETTERS.put("7", List.of("p", "q", "r", "s"));
        LETTERS.put("8", List.of("t", "u", "v"));
        LETTERS.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        return buildCombinations(digits, result, 0, "");

    }

    private List<String> buildCombinations(String digits, List<String> result, int index, String word) {
        if (digits.length() < 1 || digits == null) {
            return result;
        }

        if(index == digits.length()) {
            result.add(word);
            return result;
        }

        char currentDigit = digits.charAt(index);
        index ++;

        List<String> letters =  LETTERS.get(String.valueOf(currentDigit));

        for(String letter: letters) {
            buildCombinations(digits, result, index, word + letter);
        }
        return result;
    }
}
