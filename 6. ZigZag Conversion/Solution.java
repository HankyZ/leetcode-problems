import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); ) {

            for (int j = 0; j < numRows - 1; j++) {

                if (j == 0) {
                    if (i + numRows < s.length()) {
                        result.add(s.substring(i, i + numRows));
                    } else {
                        StringBuilder tmp = new StringBuilder();
                        tmp.append(s.substring(i));
                        for (int x = 0; x < i + numRows - s.length(); x++) {
                            tmp.append(" ");
                        }
                        result.add(tmp.toString());

                    }
                    i += numRows;
                } else {
                    StringBuilder tmp = new StringBuilder();
                    for (int a = 0; a < numRows - j - 1; a++) {
                        tmp.append(" ");
                    }
                    tmp.append(s.charAt(i));
                    for (int a = 0; a < j; a++) {
                        tmp.append(" ");
                    }
                    i++;
                    result.add(tmp.toString());
                }

                if (i >= s.length())
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (String string : result) {
                if (string.charAt(i) != ' ')
                    answer.append(string.charAt(i));
            }
        }

        return answer.toString();
    }
}