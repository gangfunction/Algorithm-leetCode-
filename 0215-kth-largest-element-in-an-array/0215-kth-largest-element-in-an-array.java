import java.util.Random;

class Solution {
    private static final Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        // k번째 큰 요소를 찾기 위해 k를 변환
        int indexToFind = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, indexToFind);
    }

    private static int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickselect(nums, left, pivotIndex - 1, k);
        } else {
            return quickselect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        // 무작위 피벗 선택
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}