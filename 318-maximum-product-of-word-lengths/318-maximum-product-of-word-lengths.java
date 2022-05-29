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
       return str1.chars().anyMatch(it -> str2.indexOf(it) > -1);
    }
    
    
}