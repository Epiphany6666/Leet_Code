package Leet_Code.title.最小化旅行的价格总和2646;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution {
    private List<Integer>[] g;
    private int[] price, cnt;
    private int end;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        cnt = new int[n];
        for (int[] t : trips) {
            end = t[1];
            dfs(t[0], -1);
        }

        this.price = price;
        int[] res = dp(0, -1);
        return Math.min(res[0], res[1]);
    }

    private boolean dfs(int x, int fa) {
        if (x == end) {
            cnt[x]++;
            return true;
        }
        for (int y : g[x]) {
            if (y != fa && dfs(y, x)) {
                cnt[x]++;
                return true;
            }
        }
        return false;
    }

    private int[] dp(int x, int fa) {
        int notHalve = price[x] * cnt[x];
        int halve = notHalve / 2;
        for (int y : g[x]) {
            if (y != fa) {
                int[] res = dp(y, x);
                notHalve += Math.min(res[0], res[1]);
                halve += res[0];
            }
        }
        return new int[] {notHalve, halve};
    }
}