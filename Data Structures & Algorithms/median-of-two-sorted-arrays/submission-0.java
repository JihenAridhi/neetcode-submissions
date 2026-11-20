class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[n+m];

        int i=0, j=0;
        for(int k=0; k<n+m; k++){
            if(i<n && j<m){
                if(nums1[i] <= nums2[j]){
                    nums[k] = nums1[i];
                    i++;
                }
                else{
                    nums[k] = nums2[j];
                    j++;

                }
            }
            else if(i>= n){
                nums[k] = nums2[j];
                j++;
            }
            else if (j>= m){
                nums[k] = nums1[i];
                i++;
            }
        }

        int mid = (n+m-1)/2;
        return (n+m) % 2 == 0 ? ((double)(nums[mid]+nums[mid+1]))/2 : nums[mid];
    }
}
