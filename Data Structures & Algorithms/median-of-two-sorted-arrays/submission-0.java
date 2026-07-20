class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        int leftSize = (n1 + n2 + 1) / 2;
        int totalLength = n1 + n2;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = leftSize - mid1;

            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;

            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                right1 = nums1[mid1];
            }

            if (mid2 < n2) {
                right2 = nums2[mid2];
            }

            if (mid1 - 1 >= 0) {
                left1 = nums1[mid1 - 1];
            }

            if (mid2 - 1 >= 0) {
                left2 = nums2[mid2 - 1];
            }

            if (left1 <= right2 && left2 <= right1) {
                if (totalLength % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return ((double) Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}