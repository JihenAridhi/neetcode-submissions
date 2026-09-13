class Solution {
    public int trap(int[] height) {

        int water = 0;

        if(height.length<=1)
            return water;

        int maxHeight = 0, maxHeightIndex = 0;
        int start = 0, end = start+1;

        while (end<height.length) {
            if(height[start]>maxHeight){
                maxHeight = height[start];
                maxHeightIndex = start;
            }
            else if(height[end]>maxHeight){
                maxHeight = height[end];
                maxHeightIndex = end;
            }
            int gap = end-start-1;
            int minHeight = Math.min(height[start], height[end]);
            if(height[start]<=height[end]){
                if(gap>0){
                    water += minHeight*gap;
                    for(int i=start+1; i<end; i++){
                        water -= height[i];
                    }
                }
                if(end<=height.length)
                    start = end;
            }
            end++;
        }
        start = height.length - 2; end = start + 1;
        while (start<end && start>=maxHeightIndex) {
            int gap = end-start-1;
            int minHeight = Math.min(height[start], height[end]);
            if(height[start]>height[end]){
                if(gap>0){
                    water += minHeight*gap;
                    for(int i=start+1; i<end; i++){
                        water -= height[i];
                    }
                }
                if(start>=maxHeightIndex)
                    end = start;
            }
            start--;
        }
        return water;
    }
}
