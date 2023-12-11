package 双周赛.第119场.第1题;

import java.util.HashMap;
import java.util.HashSet;

public class test {
}

class Solutiond2 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                cnt1++;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                cnt2++;
            }
        }
        return new int[] {cnt1, cnt2};
    }
}


class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>(){{
            for (int i : nums1) {
                add(i);
            }
        }};
        HashSet<Integer> set2 = new HashSet<>(){{
            for (int i : nums2) {
                add(i);
            }
        }};
        int[] ans = new int[2];
        for (int i : nums1) {
            if (set2.contains(i)) ans[0]++;
        }
        for (int i : nums2) {
            if (set.contains(i)) ans[1]++;
        }
        return ans;
    }
}