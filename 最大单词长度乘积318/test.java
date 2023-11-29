package title.最大单词长度乘积318;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class test {
}

/*
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];
        for (String word : words) {
            int t = 0;
            for (char c : word.toCharArray()) {
                t |= (1 << (c - 'a'));
            }
            masks[idx++] = t;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}*/

//method 2：词频相同的，我们只需要保留长度较大的
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
//        HashMap<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int t = 0;
            for (char c : word.toCharArray()) {
                t |= (c - 'a');
            }
            if (!map.containsKey(t) || map.get(t) < word.length()) map.put(t, word.length());
        }

        int ans = 0;
        for (Integer a : map.keySet()) {
            for (Integer b : map.keySet()) {
                if ((a & b) == 0) ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }
}