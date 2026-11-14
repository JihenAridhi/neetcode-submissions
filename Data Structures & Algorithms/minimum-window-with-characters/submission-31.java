class Solution {
    public String minWindow(String s, String t) {
        String res = "";

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int required = frequency.size();
        int start = -1;
        int end = 0;

        while (end < s.length()) {

            while (end < s.length() && !frequency.containsKey(s.charAt(end)))
                end++;

            if (end < s.length()) {
                if (start == -1)
                    start = end;
                frequency.put(s.charAt(end), frequency.get(s.charAt(end)) - 1);
                if (frequency.get(s.charAt(end)) == 0)
                    required--;

                while (required == 0) {
                    if (res.isEmpty() || res.length() > end - start + 1)
                        res = s.substring(start, end + 1);
                    // start++;
                    frequency.put(s.charAt(start), frequency.get(s.charAt(start)) + 1);
                    if (frequency.get(s.charAt(start)) > 0)
                        required++;
                    do {
                        start++;
                    } while (start<=end && !frequency.containsKey(s.charAt(start)));
                }

                end++;
            }
        }

        return res;
    }
}
