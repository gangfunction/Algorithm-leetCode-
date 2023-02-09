class Solution {
    public int searchInsert(int[] nums, int target) {
        int[] newNums = new int[nums.length + 1];
        for(int i = 0 ; i<nums.length ;i++){
            newNums[i] = nums[i];
        }
        newNums[nums.length] = target;
        Arrays.sort(newNums);
        
        for(int cnt = 0 ; cnt<newNums.length; cnt++){
            if(newNums[cnt] == target){
                return cnt;
            }
        }
        return 1;
    }
}