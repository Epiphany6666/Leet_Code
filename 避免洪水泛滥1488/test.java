package title.避免洪水泛滥1488;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class test {
}

/**
 * TreeSet的ceiling方法：返回大于或等于给定键的最小键，如果没有此类键，则返回 null。
 */

class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] ans = new int[len];
        TreeSet<Integer> sunny = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.fill(ans, 1);

        for (int i = 0; i < len; i++) {
            int isRain = rains[i];
            if (isRain == 0) {
                sunny.add(i);
                continue;
            } else {
                ans[i] = -1;
                if (map.containsKey(isRain)) {
                    //如果之前下过雨
//                    Integer n = sunny.ceiling(isRain);
                    Integer n = sunny.ceiling(map.get(isRain));
                    if (n == null) return new int[0];
//                    ans[n] = i;
                    ans[n] = isRain;
                    sunny.remove(n);
                }
                map.put(isRain, i);
            }
        }
        return ans;
    }
}