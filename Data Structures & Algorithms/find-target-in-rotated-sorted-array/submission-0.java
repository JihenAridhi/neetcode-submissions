class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int start=0, end=nums.length-1;

        while(start<end && target < nums[start])
            start++;
        
        while(start<end && target > nums[end])
            end--;

        while(index==-1 && start<=end){   

            int mid = (start+end)/2;
            if(target < nums[mid])
                end = mid-1;
            else if(target > nums[mid])
                start = mid + 1;
            else if(target == nums[mid])
                index = mid;
            
        }

        return index;
    }
}
