package 找出两数组的不同2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test {
}

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums1) {
            if (set2.add(i)) l2.add(i);
        }

        for (int i : nums2) {
            if (set1.add(i)) l1.add(i);
        }

        ans.add(l2);
        ans.add(l1);
        return ans;
    }
}