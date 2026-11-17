class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int area = stack.peek()[1] * (i - stack.peek()[0]);
                maxArea = Math.max(maxArea, area);
                index = stack.pop()[0];
            }
            stack.push(new int[] { index, heights[i] });
        }

        while (!stack.isEmpty()) {
            int area = stack.peek()[1] * (heights.length - stack.peek()[0]);
            maxArea = Math.max(maxArea, area);
            stack.pop();
        }

        return maxArea;
    }
}
