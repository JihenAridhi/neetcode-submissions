class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0 || heights.length == 1)
            return maxArea;

        int left = 0, right = heights.length - 1;

        while (left < right && left >= 0 && right <= heights.length - 1) {
            int width = right - left;
            int minHeight = Integer.min(heights[left], heights[right]);
            int thisArea = width * minHeight;

            if (thisArea > maxArea)
                maxArea = thisArea;

            if (heights[left] <= heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}