class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int count =0;
        int max;
        for(int i= 0; i<k; i++){
            count += nums[i];
        }
        max = count;
        
        for(int i = k; i<nums.length; i++){
            count += nums[i];
            count -= nums[i-k];
            max = Math.max(max,count);
        }
        double a = (double)k;
        double x = max/a;
        
        return x;
        
    }
}