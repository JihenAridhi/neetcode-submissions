class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        int start = 0, end = nums.length - 1;
        while (index == -1 && start <= end) {
            int i = (end + start) / 2;
            if (nums[i] < target)
                start = i+1;
            else if (nums[i] > target)
                end = i-1;
            else
                index = i;
        }

        return index;
    }
}
