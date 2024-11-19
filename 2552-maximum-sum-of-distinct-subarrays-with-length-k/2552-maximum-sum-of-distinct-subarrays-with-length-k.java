class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>(k);
        long sum = 0, max = 0;

        for (int i = 0; i < k; ++i) {
            freq.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
        }
        if (freq.size() == k)
            max = sum;

        for (int i = k; i < n; ++i) {
            freq.merge(nums[i], 1, Integer::sum);
            if (freq.merge(nums[i - k], -1, Integer::sum) == 0)
                freq.remove(nums[i - k]);
            sum += nums[i] - nums[i - k];
            if (freq.size() == k)
                max = Math.max(max, sum);
        }
        return max;
    }
}
