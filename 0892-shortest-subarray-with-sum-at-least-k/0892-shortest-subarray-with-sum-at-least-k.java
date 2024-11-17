import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int targetSum) {
        int length = nums.length;
        long[] prefixSum = new long[length + 1];
        for (int i = 0; i < length; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int shortestLength = length + 1;
        for (int currentIndex = 0; currentIndex <= length; ++currentIndex) {
            while (!deque.isEmpty() && prefixSum[currentIndex] - prefixSum[deque.peek()] >= targetSum) {
                shortestLength = Math.min(shortestLength, currentIndex - deque.poll());
            }
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[currentIndex]) {
                deque.pollLast();
            }
            deque.offer(currentIndex);
        }
        return shortestLength > length ? -1 : shortestLength;
    }
}
