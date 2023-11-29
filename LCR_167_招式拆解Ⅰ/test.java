package title.LCR_167_招式拆解;

import java.util.Arrays;
import java.util.HashMap;

public class test {
}

/*
class Solution {
    public int dismantlingAction(String arr) {
        int[] visited = new int[26];
        int ans = 0;
        char[] chars = arr.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (j < chars.length && ++visited[chars[j] - 'a'] <= 1) j++;
            ans = Math.max(ans, j - i);
            while (i < j && --visited[chars[j] - 'a'] > 1) i++;
        }
        return ans;
    }
}*/

//method 1：滑动窗口 + 哈希表
/*
class Solution {
    public int dismantlingAction(String arr) {
        int[] map = new int[52];
        int i = -1;
        int ans = 0;
        char[] chars = arr.toCharArray();
        for (int j = 0; j < arr.length(); j++) {
            //note 那如果需要更新的位置是0呢
            if (map[chars[j] - 'A'] > 0) i = Math.max(i, map[chars[j] - 'A']);
            map[chars[j] - 'A'] = j;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}*/

/*
class Solution {
    public int dismantlingAction(String arr) {
        //note 还有数字组成。。。
        int[] map = new int[52];
        int i = -1;
        int ans = 0;
        char[] chars = arr.toCharArray();
        Arrays.fill(map, -1);
        for (int j = 0; j < arr.length(); j++) {
            if (map[chars[j] - 'A'] >= 0) i = Math.max(i, map[chars[j] - 'A']);
            map[chars[j] - 'A'] = j;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}*/

/*
//method 标准答案
class Solution {
    public int dismantlingAction(String arr) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, ans = 0;
        for (int j = 0; j < arr.length(); j++) {
            if (map.containsKey(arr.charAt(j))) i = Math.max(i, map.get(arr.charAt(j)));
            map.put(arr.charAt(j), j);
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}*/

//method 动态规划
class Solution {
    public int dismantlingAction(String arr) {
        int i = -1, temp = 0, ans = 0, len = arr.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < len; j++) {
            i = map.getOrDefault(arr.charAt(j), -1);
            map.put(arr.charAt(j), j);
            temp = temp < j - i ? temp + 1 : j - i;
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}