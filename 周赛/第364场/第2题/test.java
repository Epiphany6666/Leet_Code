package 周赛.第364场.第2题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class test {
}

//分治
/*
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //首先通过二分法找到最大值
        int max = bisect(maxHeights, 0, maxHeights.size() - 1);
    }

    private int bisect(List<Integer> maxHeights, int l, int r) {
        int max = maxHeights.get(l);
        if (l == r) return max;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if ()
        }
    }
}*/

/*
//mind 都不是有序的，怎么排序啊，，，
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        part1(maxHeights, 0, 0);
    }

    private void part1(List<Integer> maxHeights, int l, int r) {
        int max = maxHeights.get(l);
        int idx = l;
        for (int i = l + 1; i <= r; i++) {
            if (maxHeights.get(i) > max) {
                max = maxHeights.get(i);
                idx = i;
            }
        }
    }
}*/

//mind 会不会想的太复杂了
/*
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] ans = new int[maxHeights.size()];
        int max = maxHeights.get(0);
        int idx = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            if (max < maxHeights.get(i)) {
                max = maxHeights.get(i);
                idx = i;
            }
        }
        int pre = max;
        for (int i = idx; i >= 0; i--) {
            if (maxHeights.get(i) <= pre) {
                ans[i] = maxHeights.get(i);
                pre = maxHeights.get(i);
            } else {
                ans[i] = pre;
            }
        }

        pre = max;
        for (int i = idx + 1; i < maxHeights.size(); i++) {
            if (maxHeights.get(i) <= pre) {
                ans[i] = maxHeights.get(i);
                pre = maxHeights.get(i);
            } else {
                ans[i] = pre;
            }
        }
        long result = 0;
        for (int an : ans) {
            result += an;
        }
        return result;
    }
}*/

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < maxHeights.size(); i++) {
            if (ans < function(maxHeights, i)) {
                ans = function(maxHeights, i);
            }
        }
        return ans;
    }

    private long function(List<Integer> maxHeights, int idx) {
        int[] ans = new int[maxHeights.size()];
        int pre = maxHeights.get(idx);
        for (int i = idx; i >= 0; i--) {
            if (maxHeights.get(i) <= pre) {
                ans[i] = maxHeights.get(i);
                pre = maxHeights.get(i);
            } else {
                ans[i] = pre;
            }
        }

        pre = maxHeights.get(idx);
        for (int i = idx + 1; i < maxHeights.size(); i++) {
            if (maxHeights.get(i) <= pre) {
                ans[i] = maxHeights.get(i);
                pre = maxHeights.get(i);
            } else {
                ans[i] = pre;
            }
        }
        long result = 0;
        for (int an : ans) {
            result += an;
        }
        return result;
    }
}