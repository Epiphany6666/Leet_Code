package title.单词拆分139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
}

//method 序列dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (String string : wordDict) {
            set.add(string);
        }

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && !dp[i]; j++) {
                String sub = s.substring(j - 1, i);
                if (set.contains(sub)) dp[i] = dp[j - 1];
            }
        }
        return dp[len];
    }
}