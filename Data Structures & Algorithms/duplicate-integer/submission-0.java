class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean duplicate = false;

        int i = 0;
        while(i<nums.length-1 && !duplicate)
        {
            int j = i+1;
            while(j<nums.length && !duplicate)
            {
                duplicate = nums[j]==nums[i];
                j++;
            }
            i++;
        }

        return duplicate;
    }
}