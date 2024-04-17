class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i]는 이전 단계에서의 결과를 나타냄
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 빈 문자열은 빈 패턴과 일치함

        // 패턴 p가 *로 시작하는 경우를 고려하여 초기화
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2]; // *가 이전 문자를 삭제하는 경우
            }
        }

        // 나머지 경우에 대한 DP 수행
        for (int i = 1; i <= m; i++) {
            boolean prev = dp[0]; // 이전 단계에서의 결과를 저장
            dp[0] = false; // 이전 단계에서 패턴이 빈 문자열과만 일치하는지 확인

            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                boolean temp = dp[j]; // 현재 dp[j]의 값을 임시 변수에 저장

                if (sc == pc || pc == '.') {
                    dp[j] = prev; // 현재 단계의 결과를 이전 단계의 결과로 갱신
                } else if (pc == '*') {
                    char pPrev = p.charAt(j - 2);
                    if (pPrev == sc || pPrev == '.') {
                        dp[j] = dp[j - 2] || dp[j]; // *가 이전 문자를 삭제하거나 여러 번 반복하는 경우
                    } else {
                        dp[j] = dp[j - 2]; // *가 이전 문자를 삭제하는 경우
                    }
                } else {
                    dp[j] = false; // 현재 문자와 패턴이 일치하지 않는 경우
                }
                
                prev = temp; // 이전 단계의 결과를 갱신
            }
        }

        return dp[n];
    }
}