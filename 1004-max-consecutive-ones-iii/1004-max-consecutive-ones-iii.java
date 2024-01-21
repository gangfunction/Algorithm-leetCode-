class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 , right = 0, window_size = 0;
        int countNum = countZero(nums, k);
        
        if(countNum <= k){
            return nums.length;
        }
        for(right = 0; right<nums.length; right++){
            if(nums[right]==0){
                k--;
            }
            if(k<0){
                k+=1-nums[left];
                left++;
            }
            
        }
        
        return right-left;
    }
    
    public int countZero(int[] nums, int k) {
            int count = 0;         
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;       
            }     
        }     
        return count;    
    }
}