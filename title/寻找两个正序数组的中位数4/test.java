package title.寻找两个正序数组的中位数4;

public class test {
    public static void main(String[] args) {
        new Solution().findMedianSortedArrays(
                new int[] {1, 3},
                new int[] {2}
        );
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        double[] merge = new double[len];
        int idx1 = 0, idx2 = 0, idx3 = 0;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] < nums2[idx2]) {
                merge[idx3++] = nums1[idx1++];
            } else {
//                merge[idx3++] = nums1[idx2++];
                merge[idx3++] = nums2[idx2++];
            }
        }
        while (idx1 < m) {
            merge[idx3++] = nums1[idx1++];
        }
        while (idx2 < n) {
//            merge[idx3++] = nums1[idx2++];
            merge[idx3++] = nums2[idx2++];
        }

        if (len % 2 == 1) {
            return merge[len / 2];
        } else {
            return (merge[len / 2] + merge[len / 2 - 1]);
        }
    }
}