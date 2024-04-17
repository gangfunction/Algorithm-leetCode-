
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j]는 s의 처음 i개 문자와 p의 처음 j개 문자가 일치하는지 여부를 나타냄
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // 빈 문자열은 빈 패턴과 일치함

        // 패턴 p가 *로 시작하는 경우를 고려하여 초기화
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // *가 이전 문자를 삭제하는 경우
            }
        }

        // 나머지 경우에 대한 DP 수행
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char pPrev = p.charAt(j - 2);
                    if (pPrev == sc || pPrev == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[m][n];
    }
}