class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : nums) {
            frequency.putIfAbsent(n, 0);
            frequency.put(n, frequency.get(n) + 1);
        }

        PriorityQueue<Integer> queue =
            new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a));
        for (Integer n : frequency.keySet()) {
            queue.offer(n);
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll();
        }

        return topK;
    }
}
