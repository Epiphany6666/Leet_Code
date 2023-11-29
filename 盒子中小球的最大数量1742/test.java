package title.盒子中小球的最大数量1742;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        new Solution().countBalls(1, 10);
    }
}

/*
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        for (int i = lowLimit; i <= highLimit; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        Collection values = map.values();
        for (Object value : values) {
            ans = Math.max(ans, (Integer) value);
        }

        return ans;
    }
}*/

//哈希表简化
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        for (int i = lowLimit; i <= highLimit; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans = Math.max(ans, map.get(sum));
        }

        return ans;
    }
}