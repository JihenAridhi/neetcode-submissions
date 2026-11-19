class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int start=0, end=nums.length-1;
        int pivot=0;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[end])
                start = mid+1;
            else 
                end = mid;
        }
        pivot = start;

        start = target>=nums[0] ? 0 : pivot;
        end = target<=nums[nums.length-1] ? nums.length-1 : pivot-1;

        while(index==-1 && start<=end){
            int mid = (start+end)/2;

            if(nums[mid] < target)
                start = mid+1;
            else if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid] == target)
                index = mid;
        }

        return index;
    }
}
