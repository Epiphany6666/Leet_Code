package title.分发饼干455;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0, j = 0; i < g.length; i++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j >= s.length) break;
            ans++;
            j++;
        }
        return ans;
    }
}*/

//method 简化
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0, j = 0; i < g.length; i++, j++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j < s.length) {
                ans++;
            }
        }
        return ans;
    }
}