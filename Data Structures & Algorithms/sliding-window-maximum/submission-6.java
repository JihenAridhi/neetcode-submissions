class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0, end = 0;

        while (start < nums.length - k + 1 && end < nums.length) {
            while (!deque.isEmpty() && nums[end] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(end);

            if (end == start + k - 1) {
                res[start] = nums[deque.peek()];
                if (deque.peek() <= start)
                    deque.pop();
                start++;
            }
            end++;
        }

        return res;
    }
}
