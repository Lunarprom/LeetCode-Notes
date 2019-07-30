class Solution {
    public int lengthOfLastWord(String s) {
        char[] charS = s.trim().toCharArray();
        for (int i = charS.length - 1; i >= 0; i--) {
            if (charS[i] == ' ') {
                return charS.length - i - 1;
            }
        }
        return charS.length < 1 ? 0 : charS.length;
    }
}