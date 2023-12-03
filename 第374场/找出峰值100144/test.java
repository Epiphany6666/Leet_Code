package 周赛.第374场.找出峰值100144;

import java.util.LinkedList;
import java.util.List;

public class test {
}

class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) ans.add(i);
        }
        return ans;
    }
}