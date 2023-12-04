package title.到达首都的最少油耗2477;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution {
    //note 注意返回值为long
    //    int ans = 0;
    int ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
//        Arrays.fill(g,new ArrayList<>());
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] road : roads) {
            int x = road[0], y = road[1];
            g[x].add(y);
            g[y].add(x);
        }

        dfs(0, -1, g, seats);
        return ans;
    }

    private int dfs(int cur, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int x : g[cur]) {
            if (x != fa) {
                size += dfs(x, cur, g, seats);
            }
        }
        ans += (size + seats - 1) / seats;
        return size;
    }
}