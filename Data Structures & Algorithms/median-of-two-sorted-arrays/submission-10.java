class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length, l = n + m;
        int start = 0, end = n;

        while (true) {
            int i = (start + end) / 2, j = (l + 1) / 2 - i;
            int left1 = i < 1 ? Integer.MIN_VALUE : nums1[i - 1],
                right1 = n > 0 && i < n ? nums1[i] : Integer.MAX_VALUE,
                left2 = j < 1 ? Integer.MIN_VALUE : nums2[j - 1],
                right2 = m > 0 && j < m ? nums2[j] : Integer.MAX_VALUE;

            if (left1 > right2)
                end = i - 1;
            else if (left2 > right1)
                start = i + 1;
            else
                return l % 2 == 0 ? (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2
                                  : Math.max(left1, left2);
        }
    }
}
