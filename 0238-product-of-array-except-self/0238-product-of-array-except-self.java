class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N= nums.length;
        int[] left_products = new int[N];
        int[] right_products = new int[N];
        int[] output_arr = new int[N];
        
        left_products[0]=1;
        right_products[N-1]=1;
        
        for(int i =1; i<N;i++){
            left_products[i] = nums[i-1]*left_products[i-1];
            right_products[N-i-1] = nums[N-i]*right_products[N-i];
        }
        for(int i=0; i<N; i++){
            output_arr[i] =  left_products[i]*right_products[i];
        }
        return output_arr;
        
        
        }
    }
