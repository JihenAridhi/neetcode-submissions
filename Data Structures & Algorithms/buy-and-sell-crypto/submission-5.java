class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length<=1)
            return 0;

        int maxValue = 0;
        int start = 0, end = start + 1;
        int currentValue = 0;

        while(end<prices.length){
            if(prices[end]<prices[start]){
                start=end;
            }
            else{
                currentValue = prices[end] - prices[start];
                maxValue = Math.max(maxValue, currentValue);
            }
            end++;
        }
        return maxValue;
    }
}
