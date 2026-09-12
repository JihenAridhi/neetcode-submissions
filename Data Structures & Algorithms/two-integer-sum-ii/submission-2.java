class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = 1;

        while(start<numbers.length-1 && end<numbers.length){
            if(numbers[start]+numbers[end]<target){
                start++;
                end++;
            }
            else if(numbers[start]+numbers[end]>target)
                start--;
            else
                break;
        }
        
        return new int[] {start+1, end+1};
    }
}
