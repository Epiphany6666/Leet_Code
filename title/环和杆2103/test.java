package title.环和杆2103;

import java.util.HashMap;
import java.util.HashSet;

public class test {
}

/*
class Solution {
    public int countPoints(String rings) {
        int ans = 0;
        HashMap<Integer, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length() / 2; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < rings.length(); i += 2) {
            int j = Integer.parseInt(rings.charAt(i + 1) + "");
            HashSet<Character> set = map.get(j);
            set.add(rings.charAt(i));
            if (set.size() == 3) ans++;
            map.put(j, set);
        }
    }
}*/

//method 1：位运算 - 统计环
class Solution {
    public int countPoints(String rings) {
        int[] map = new int[128];

        int ans = 0;
        for (int i = 0; i < rings.length(); i += 2) {
            map[rings.charAt(i) - 'B'] |= 1 << (rings.charAt(i + 1) - '0');
        }
        for (int i = 0; i < 10; i++) {
            int total = 0;
            for (char c : new char[] {'R', 'G', 'B'}) total += 1 & (map[c - 'B'] >> i);
            if (total == 3) ans++;
        }
        return ans;
    }
}