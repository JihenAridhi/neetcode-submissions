class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums.length == 3 && nums[0] + nums[1] + nums[2] != 0)
            return res;
        else if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            res.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return res;
        } else {
            Arrays.sort(nums);
            System.out.println("Sorted nums: " + Arrays.toString(nums));
            for (int i = 0; i < nums.length - 2; i++) {
                int target = -nums[i];
                int start = i + 1, end = nums.length - 1;
                while (start < end && start > i && end < nums.length) {
                    if (nums[start] + nums[end] == target) {
                        if (!res.contains(Arrays.asList(nums[i], nums[start], nums[end]))) 
                            res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (res.contains(Arrays.asList(nums[i], nums[start], nums[end]))
                            && start < end && start > i && end < nums.length) {
                            if (end == nums.length - 1 || start > i + 1)
                                start++;
                            if (end < nums.length && start == i + 1)
                                end--;
                        }
                    }
                    else if (nums[start] + nums[end] < target)
                        start++;
                    else if (nums[start] + nums[end] > target)
                        end--;
                }
            }
            return res;
        }
    }
}
