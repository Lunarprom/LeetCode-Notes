class Solution {
    public int lengthOfLastWord(String s) {
        char[] charS = s.toCharArray();
        int count = 0;
    
        for (int i = charS.length - 1; i >= 0; i--) {
            if (count != 0 && charS[i] != ' ') {
                count++;
            } else if (count != 0 && charS[i] == ' ') {
                return count;
            } else if (count == 0 && charS[i] != ' ') {
                count++;
            }
        }
        return count;
    }
}