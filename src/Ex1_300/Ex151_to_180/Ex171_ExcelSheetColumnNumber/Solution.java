package Ex1_300.Ex151_to_180.Ex171_ExcelSheetColumnNumber;

import java.util.Locale;

public class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return -1;
        }
        int sum = 0;
        for (char c : columnTitle.toUpperCase(Locale.ROOT).toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
