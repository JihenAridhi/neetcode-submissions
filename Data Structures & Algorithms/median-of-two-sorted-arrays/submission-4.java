class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length, l = n + m;
        int i = n / 2 - 1;
        int j = l / 2 - i - 2;

        while (i < n && j < m) {
            if (i < n - 1 && j >= 0 && nums1[i + 1] < nums2[j]) {
                i++;
                j--;
            } else if (i >= 0 && j < m - 1 && nums1[i] > nums2[j + 1]) {
                i--;
                j++;
            } else
                break;
        }

        if (l % 2 == 0)
            return (double) (Math.max(i < 0 ? Integer.MIN_VALUE : nums1[i], j < 0 ? Integer.MIN_VALUE : nums2[j]) +
                    Math.min(i < n - 1 ? nums1[i + 1] : Integer.MAX_VALUE,
                            j < m - 1 ? nums2[j + 1] : Integer.MAX_VALUE))
                    / 2;

        return Math.min(i < n - 1 ? nums1[i + 1] : Integer.MAX_VALUE, j < m - 1 ? nums2[j + 1] : Integer.MAX_VALUE);
    }
}
