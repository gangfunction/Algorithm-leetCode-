class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean flag = false;
        int[] answer = new int[2];
        int[] answer2= new int[2];
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(int num : nums){
            if(target/2 != num){
                int b = target - num;
                int c =list.indexOf(b);   
                if( c != -1){
                int d = list.indexOf(num);            
                list.remove(list.indexOf(num));                
                answer[0]=d;
                answer[1]=c;
                flag = true;
                }
            }
        }
        if(flag == false){
            int a = target/2;
            answer2[0] = list.indexOf(a);
            answer2[1] = list.lastIndexOf(a);
            
        }
        return flag? answer :answer2 ;

        
    }
}