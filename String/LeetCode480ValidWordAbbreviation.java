public class LeetCode480ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word != null && abbr == null || abbr.length() > word.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') {
                    // The digit can't be 0.
                    return false;
                }
                int value = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    value = value * 10 + (int) abbr.charAt(j) - '0';
                    j++;
                }
                i += value;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++)) {
                    return false;
                }
            }
        }

        return i == word.length() && j == abbr.length();
    }
}
