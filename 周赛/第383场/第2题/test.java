package 周赛.第383场.第2题;

public class test {
    public static void main(String[] args) {
        new Solution().minimumTimeToInitialState("aab", 2);
    }
}

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int t = 0;
        int ans = Integer.MAX_VALUE;
        String w = word;
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            String a = w.substring(0, k);
            String b = w.substring(k);
            sb.append(b);
            sb.append(a);
            t++;
            if (b.contains(word.substring(0, b.length()))) {
                ans = t;
                break;
            }
            w = sb.toString();
        }
        return ans;
    }
}