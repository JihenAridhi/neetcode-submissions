class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(min > nums[mid]){
                min = nums[mid];
                end = mid -1;
            }
            else
                start = mid + 1;
        }
        
        return min;
    }
}
