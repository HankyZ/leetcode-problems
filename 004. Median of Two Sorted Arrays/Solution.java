class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        int counter = 0;
        int index1 = 0;
        int index2 = 0;

        while ((size % 2 == 0 && counter < size / 2 - 1) || (size % 2 == 1 && counter < size / 2)) {

            if (index1 >= nums1.length)
                index2++;
            else if (index2 >= nums2.length)
                index1++;
            else if (nums1[index1] <= nums2[index2])
                index1++;
            else
                index2++;

            counter++;
        }

        if (size % 2 == 0) {

            if (index1 >= nums1.length)
                return ((double) nums2[index2] + (double) nums2[++index2]) / 2;

            if (index2 >= nums2.length)
                return ((double) nums1[index1] + (double) nums1[++index1]) / 2;

            int medians[] = new int[2];

            for (int i = 0; i < medians.length; i++) {

                if (index1 >= nums1.length) {
                    medians[i] = nums2[index2];
                    index2++;
                } else if (index2 >= nums2.length) {
                    medians[i] = nums1[index1];
                    index1++;
                } else if (nums1[index1] <= nums2[index2]) {
                    medians[i] = nums1[index1];
                    index1++;
                } else {
                    medians[i] = nums2[index2];
                    index2++;
                }
            }
            return ((double) medians[0] + (double) medians[1]) / 2;
        }

        if (index1 >= nums1.length)
            return nums2[index2];

        if (index2 >= nums2.length)
            return nums1[index1];

        if (nums1[index1] <= nums2[index2])
            return nums1[index1];

        return nums2[index2];
    }

}