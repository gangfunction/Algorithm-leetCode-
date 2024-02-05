class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        
        if (minHeap.size() > k) {
            minHeap.poll(); 
        }
    }
    return minHeap.poll(); 
    }

  }
    //         if(k==1){
//             Arrays.sort(nums, Collections.reverseOrder());
//             return nums[0];
//         }
//         int[] target= Arrays.copyOf(nums);        
//         for(int i=0; i<k-1; i++){
//             int num = target.length;
//             Arrays.sort(target, Collections.reverseOrder());
//             Arrays.sort(target, 1, num-1);
            
//         }
//         return target[0];