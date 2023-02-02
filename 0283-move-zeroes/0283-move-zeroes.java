class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length ==1){
            System.out.println(Arrays.toString(nums));
        }else{
            int zeroCount = 0;
            int fillCount = 0;
            for(int i = 0; i<nums.length; i++){
                if(nums[i]==0){
                    zeroCount++;
                }
                else{
                    nums[fillCount]=nums[i];
                    fillCount++; 
                }
            }
            for(int j =fillCount; j<nums.length; j++){
                nums[j]=0;
            }
            
        }
        
    }
}