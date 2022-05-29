class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j ++) {
                String word1 = words[i];
                String word2 = words[j];
                if (!hasSameLetter(word1, word2)) {
                    max = Math.max(word1.length() * word2.length(), max);
                }
            }
        }
        return max;
    }

    private boolean hasSameLetter(String str1, String str2) {
        int bitmask1 = 0, bitmask2 = 0;
        for (char ch : str1.toCharArray())
            bitmask1 |= 1 << bitNumber(ch);
        for (char ch : str2.toCharArray())
            bitmask2 |= 1 << bitNumber(ch);

        return (bitmask1 & bitmask2) != 0;
    }

    private int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }
}
