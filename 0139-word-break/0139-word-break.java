class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (s.isEmpty()) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && wordBreakHelper(s.substring(i), wordSet, memo)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }
}