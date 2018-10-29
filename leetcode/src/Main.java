import java.util.*;

public class Main {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, total/2) +
                    findKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, total/2 + 1))/2.0f;
        } else {
            return findKth(nums1, nums2, 0, len1 - 1, 0, len2 - 1, total/2 + 1);
        }
    }

    public double findKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return findKth(nums2, nums1, start2, end2, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int ia = Math.min(k/2, len1);
        int ib = k - ia;
        if (nums1[start1 + ia - 1] > nums2[start2 + ib - 1]) {
            return findKth(nums1, nums2, start1, end1, start2 + ib, end2, k - ib);
        } else if (nums1[start1 + ia - 1] < nums2[start2 + ib - 1]) {
            return findKth(nums1, nums2, start1 + ia, end1, start2, end2, k - ia);
        } else {
            return nums1[start1 + ia - 1];
        }
    }


    public static void main(String[] args) {

    }
}
