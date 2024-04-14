class Solution {
    /**
    1. 문제해석: int[]배열 nums를 받아서 최댓값을 구축하는 subarray의 합을 리턴한다.
    2. 방법: 분할정복
    3. 순서: 
        1. 중간 피벗을 정하고 좌우의 합을 구한다.
        2. 더 큰쪽의 배열을 정복한다.
        3. 반복
    */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // 배열이 비어있거나 null인 경우 처리
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
//     public int maxSubArray(int[] nums) {
//         if(nums.length ==0){
//             return 0;
//         }
//         return maxSubArrayCalculator(nums, 0, nums.length-1);
//     }
//     private int maxSubArrayCalculator(int[] nums,int left, int right){
//         if(left>right){
//             return Integer.MIN_VALUE;
//         }
//         int mid = left + (right-left)/2;
//         int leftMax = maxSubArrayCalculator(nums, left, mid-1);
//         int rightMax= maxSubArrayCalculator(nums, mid+1, right);
        
//         int leftSum =0, rightSum=0;
//         int sum=0;
        
//         for(int i = mid-1; i>=left ; i--){
//             sum+= nums[i];
//             leftSum = Math.max(leftSum, sum);
//         }
//         sum =0;
//         for(int i = mid+1; i<= right; i++){
//             sum += nums[i];
//             rightSum = Math.max(rightSum,sum);    
//         }
//         int midMax = nums[mid] + leftSum+ rightSum;
//         return Math.max(midMax, Math.max(leftMax, rightMax));
//     }
}