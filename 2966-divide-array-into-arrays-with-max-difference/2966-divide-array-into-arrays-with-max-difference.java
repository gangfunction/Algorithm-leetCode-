class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] list2 = {};

        List<Integer> answer2 = new ArrayList<>();
        int b= nums.length/3;
        int[][] answers = new int[nums.length/3][3];
        int[] answers2 = new int[3];
        for(int i=1; i<b+1; i++){
            int f = nums[3*i-3];  
            int g = nums[3*i-2];
            int h = nums[3*i-1];
            answers2[0]= f;
            answers2[1]= g;
            answers2[2]= h;
            answers[i-1]=answers2;
            if(g-f>k || h-g>k || h-f>k){
                return list2;
            }
            answers2 = new int[3];
        }
        
        return answers;
    }
}