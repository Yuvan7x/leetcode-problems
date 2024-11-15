class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        int start = 0, end = length - 1;

        while (start + 1 < length && arr[start] <= arr[start + 1]) {
            ++start;
        }
        while (end - 1 >= 0 && arr[end - 1] <= arr[end]) {
            --end;
        }
        if (start >= end) {
            return 0;
        }

        int minLength = Math.min(length - start - 1, end);
        for (int left = 0; left <= start; ++left) {
            int right = binarySearch(arr, arr[left], end);
            minLength = Math.min(minLength, right - left - 1);
        }
        return minLength;
    }

    private int binarySearch(int[] arr, int target, int leftBound) {
        int rightBound = arr.length;
        while (leftBound < rightBound) {
            int mid = (leftBound + rightBound) >> 1;
            if (arr[mid] >= target) {
                rightBound = mid;
            } else {
                leftBound = mid + 1;
            }
        }
        return leftBound;
    }
}
