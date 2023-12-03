package 周赛.第373场.统计美丽子字符串I2947;

import java.util.HashSet;
import java.util.Set;

public class test {
}

class Solution {
    public int beautifulSubstrings(String s, int k) {
        Set<Character> vowels = new HashSet<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};

        int len = s.length(), ans = 0;
        for (int i = 0; i < len; i++) {
            int cnt1 = 0, cnt2 = 0;
            for (int j = i; j < len; j++) {
                if (vowels.contains(s.charAt(j))) cnt1++;
                else cnt2++;
                if (cnt1 == cnt2 && cnt1 * cnt2 % k == 0) ans++;
            }
        }
        return ans;
    }
}