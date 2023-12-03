package 周赛.第366场.第2题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().minProcessingTime(new ArrayList<>(Arrays.asList(8, 10)),
                new ArrayList<>(Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5)));
    }
}

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime, (i, j) -> (j - i));
        Collections.sort(tasks);
        int[] t = new int[processorTime.size()];
//        Arrays.fill(t, Integer.MAX_VALUE);
        Arrays.fill(t, Integer.MIN_VALUE);
        for (int i = 0; i < processorTime.size(); i++) {
            int spareTime = processorTime.get(i);
            int k = 4 * i + 4;
            for (int j = 4 * i; j < k; j++) {
//                t[i] = Math.min(t[i], tasks.get(j) + spareTime);
                t[i] = Math.max(t[i], tasks.get(j) + spareTime);
            }
        }
        return Arrays.stream(t).max().getAsInt();
    }
}