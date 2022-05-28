class Solution {
    private List<String> dict;
    private Set<Set<String>> mem = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = wordDict.stream().filter(s::contains).collect(Collectors.toList());
        return dp(s, new HashSet<>());
    }

    private boolean dp(String s, Set<String> allWords) {
        if (s.isEmpty()) return true;
        if (mem.contains(allWords)) return false;
        for (String word : dict) {
            if (s.startsWith(word)) {
                Set<String> newSet = new HashSet<>(allWords);
                newSet.add(word);
                if (dp(s.replaceFirst(word, ""), newSet)) {
                    return true;
                }
            }
        }
        mem.add(allWords);
        return false;
    }
}