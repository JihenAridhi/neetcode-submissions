class Solution {
    public int characterReplacement(String s, int k) {
        int maxF = 0;
        int res = 0;
        Map<Character, Integer> frequency = new HashMap<>();

        int start = 0, end = 0;
        while (start <= end && end < s.length()) {
            frequency.put(s.charAt(end), frequency.getOrDefault(s.charAt(end), 0) + 1);
            maxF = Math.max(maxF, frequency.get(s.charAt(end)));
            int window = end - start + 1;
            int gap = window - maxF;
            if (gap > k) {
                frequency.put(s.charAt(start), frequency.get(s.charAt(start)) - 1);
                start++;
            } else
                res = window;
            end++;
        }

        return res;
    }
}
