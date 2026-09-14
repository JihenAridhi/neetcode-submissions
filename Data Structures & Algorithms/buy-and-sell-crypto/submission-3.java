class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = start + 1;
        int maxValue = 0;
        while (end < prices.length) {
            if (prices[start] < prices[end])
                maxValue = Math.max(maxValue, prices[end] - prices[start]);
            else
                start = end;
            end++;
        }
        return maxValue;
    }
}
