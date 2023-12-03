package title.重复的DNA序列187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test {
}

/*
//method 1：暴力
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        int len = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= len; i++) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if (cnt == 1) ans.add(cur);
            map.put(cur, cnt + 1);
        }
        return ans;
    }
}*/

//method 2：字符串哈希 + 前缀和
class Solution {
    int N = (int)1e5 + 10, P = 131313;
    int[] h = new int[N], p = new int[N];
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new LinkedList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i +1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, j));
            map.put(hash, cnt + 1);
        }
        return ans;
    }
}