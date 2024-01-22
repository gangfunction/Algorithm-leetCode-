class Solution {
    /*
    문제는 곱셈을 해야하므로 곱셈을 전의것만 할수밖에 없으니까, 곱셈의 순서를 좌의 곱과 우의곱으로 나눈다는것.
    */
    public int[] productExceptSelf(int[] nums) {
        int N= nums.length, R =1;
        int[] output_arr = new int[N];
        output_arr[0]=1;
        for(int i=1; i<N; i++ ){
            output_arr[i]=nums[i-1]*output_arr[i-1];
        }
        for(int i=N-1; i>=0; i--){
            output_arr[i] = output_arr[i]*R;
            R= R*nums[i];
        }
        return output_arr;
        
        
        }
    }
