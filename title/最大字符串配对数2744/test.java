package title.最大字符串配对数2744;

import java.util.HashSet;
import java.util.Set;

public class test {
}

class Solution1 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String words1 = words[i], words2 = words[j];
                if (words1.length() != words2.length()) break;
                int k = 0;
                for (; k < words1.length(); k++) {
                    if (words1.charAt(k) != words2.charAt(words1.length() - k - 1)) break;
                }
                if (k == words1.length()) ans++;
            }
        }
        return ans;
    }
}

// note 仔细审题，words[i].length == 2
class Solution2 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

//method 2：哈希表
class Solution3 {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (String word : words) {
            if (set.contains(word.charAt(1) * 100 + word.charAt(0))) ans++;
            set.add(word.charAt(0) * 100 + word.charAt(1));
        }
        return ans;
    }
}

//method 3：数组
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        boolean[][] seen = new boolean[26][26];
        int ans = 0;
        for (String word : words) {
            int x = word.charAt(0) - 'a';
            int y = word.charAt(1) - 'a';
            if (seen[y][x]) ans++;
            seen[x][y] = true;
        }
        return ans;
    }
}