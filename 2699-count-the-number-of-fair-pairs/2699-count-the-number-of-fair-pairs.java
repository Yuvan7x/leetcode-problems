import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] array, int minSum, int maxSum) {
        Arrays.sort(array);
        long count = 0;

        for (int i = 0; i < array.length; ++i) {
            count += binarySearch(array, maxSum - array[i] + 1, i + 1) - binarySearch(array, minSum - array[i], i + 1);
        }
        return count;
    }

    private int binarySearch(int[] array, int target, int start) {
        int end = array.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
