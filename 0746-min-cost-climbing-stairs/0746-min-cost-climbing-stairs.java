class Solution {
    /**
    문제해석: 비용비교 로직이 제일 크게차지함.
    시작하는건 0인덱스 또는 2번째 인덱스에서 가능하고,
    스텝의 수는 1개에서 2개뛸수있지
    
    */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 0);
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2; i<length; i++){
            dp[i]= Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[length-1],dp[length-2]);
        
        
    }
}