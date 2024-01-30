package title.查找和最小的K对数字373;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class test {
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                list.add(List.of(n1, n2));
            }
        }
        Collections.sort(list, (i, j) -> ((i.get(0) + i.get(1)) - (j.get(0) + j.get(1))));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i));
        }
        return ans;
    }
}