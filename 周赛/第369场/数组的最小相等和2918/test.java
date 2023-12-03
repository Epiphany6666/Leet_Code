package 周赛.第369场.数组的最小相等和2918;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

public class test {

}

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0;
        boolean zero1 = false;
        for (int x : nums1) {
            if (x == 0) {
                s1++;
                zero1 = true;
            } else {
                s1 += x;
            }
        }

        long s2 = 0;
        boolean zero2 = false;
        for (int x : nums2) {
            if (x == 0) {
                s2++;
                zero2 = true;
            } else {
                s2 += x;
            }
        }

        if ((!zero1 && zero2 && s1 < s2) ||
                (zero1 && !zero2 && s1 > s2) ||
                (!zero1 && !zero2 && s1 != s2)) return -1;
        return Math.max(s1, s2);
    }
}