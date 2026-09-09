class Solution {
    public int[] twoSum(int[] nums, int target) {

        boolean targetFound = false;
        
        int[] indices = new int[2];

        int i=0;
        int j=0;
        while(i<nums.length && !targetFound){
            j=0;
            while(j<nums.length && !targetFound){
                if(i==j)
                    j++;
                targetFound = (nums[i]+nums[j])==target;
                j++;
            }
            i++;
        }

        if(targetFound){
            indices[0]=i-1; 
            indices[1]=j-1;
        }

        return indices;
    }
}
