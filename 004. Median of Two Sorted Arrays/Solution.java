class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        if (size == 1)
            return nums2.length == 0 ? nums1[0] : nums2[0];

        int counter = 0;
        int index1 = 0;
        int index2 = 0;
        int medians[] = {0, 0};

        while (counter < size / 2 - 1) {

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

        for (int i = 0; i < medians.length; i++) {

            if (index1 >= nums1.length)
                medians[i] = nums2[index2++];

            else if (index2 >= nums2.length)
                medians[i] = nums1[index1++];

            else if (nums1[index1] <= nums2[index2])
                medians[i] = nums1[index1++];

            else
                medians[i] = nums2[index2++];
        }

        if (size % 2 == 1)
            return medians[1];

        return ((double) medians[0] + (double) medians[1]) / 2;
    }

}