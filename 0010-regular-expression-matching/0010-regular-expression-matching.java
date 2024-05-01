class Solution {
    // 시간복잡도 O(n*m) 공간복잡도 O(n)
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; 

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2]; 
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean prev = dp[0]; 
            dp[0] = false; 

            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                boolean temp = dp[j]; 
                if (sc == pc || pc == '.') {
                    dp[j] = prev; 
                } else if (pc == '*') {
                    char pPrev = p.charAt(j - 2);
                    if (pPrev == sc || pPrev == '.') {
                        dp[j] = dp[j - 2] || dp[j]; 
                    } else {
                        dp[j] = dp[j - 2];
                    }
                } else {
                    dp[j] = false; 
                }
                
                prev = temp; 
            }
        }

        return dp[n];
    }
}