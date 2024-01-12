package title.统计出现过一次的公共字符串2085;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
}

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>(){{
            for (String s : words1) {
                put(s, getOrDefault(s, 0) + 1);
            }
        }};
        Map<String, Integer> map2 = new HashMap<>(){{
            for (String s : words2) {
                put(s, getOrDefault(s, 0) + 1);
            }
        }};
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.get(entry.getKey()) == 1) {
                ans++;
            }
        }
        return ans;
    }
}