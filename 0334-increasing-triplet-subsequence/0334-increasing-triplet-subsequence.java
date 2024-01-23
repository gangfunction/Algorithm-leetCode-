class Solution {
    /*
    인덱스가 커져야하고 값도 3개이상 커지는 경우의수.
    */
    public boolean increasingTriplet(int[] nums) {
        if ( nums.length < 3) {
            return false;
        }

        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= small) {
                small = num; // smallest so far
            } else if (num <= secondSmall) {
                secondSmall = num; // second smallest
            } else {
                // Found a number greater than both small and secondSmall
                return true;
            }
        }
        return false;
    }
}