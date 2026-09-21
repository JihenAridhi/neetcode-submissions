class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        int start = 0, end = start + 1;
        while (start < end && end < temperatures.length) {
            if (temperatures[end] > temperatures[start]) {
                res[start] = end - start;
                start++;
                end = start + 1;
            } else if (res[start] == 0 && end == temperatures.length - 1) {
                start++;
                end = start + 1;
            } else
                end++;
        }
        return res;
    }
}
