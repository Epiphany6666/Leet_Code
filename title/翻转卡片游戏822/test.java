package title.翻转卡片游戏822;

import java.util.*;

/**
 * 总结
 * 1.正难则反
 * 2.答案为最小值不一定要通过方法来求。。。
 * 3.没有答案返回0，则直接将res除余即可
 * 4.最大值不一定要为Integer.MAX_VALUE，可以看题目给的范围
 */
public class test {
}

/*
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        List<Integer> list = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fronts.length; i++) {
            if (!map.containsKey(fronts[i])) {
                map.put(fronts[i], 1);
            } else {
                map.put(fronts[i], map.get(fronts[i]) + 1);
            }
            if (!map.containsKey(backs[i])) {
                map.put(backs[i], 1);
            } else {
                map.put(backs[i], map.get(backs[i]) + 1);
            }
        }
        for (int i = 0; i < fronts.length; i++) {
            int f = fronts[i];
            int b = backs[i];
            if (map.get(f) == 1) {
                list.add(f);
            }
            if (map.get(b) == 1) {
                list.add(b);
            }
        }
        return list.size() == 0 ? 0 : Collections.min(list);
    }
}*/

/*
//,,,,我在想什么，正难则反
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) same.add(fronts[i]);
        }
        for (int i = 0; i < fronts.length; i++) {
            int f = fronts[i];
            int b = backs[i];
            if (!same.contains(f)) list.add(f);
            if (!same.contains(b)) list.add(b);
        }
        return list.size() == 0 ? 0 : Collections.min(list);
    }
}*/

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int res = Integer.MAX_VALUE;
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) same.add(fronts[i]);
        }
        for (int i = 0; i < fronts.length; i++) {
            int f = fronts[i];
            int b = backs[i];
            if (f < res && !same.contains(f)) res = f;
            if (b < res && !same.contains(b)) res = b;
        }
        return res % Integer.MAX_VALUE;
    }
}