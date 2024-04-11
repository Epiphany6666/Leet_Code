package title.互质树1766;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
}

/**
 * 参考题解：宫水三叶
 */
// 预处理。。。
class Solution {
    List<Integer>[] g;
    int[] ans;
    int[] pos = new int[52];
    int[] dep;
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        ans = new int[n];
        dep = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(pos, -1);
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }
        dfs(nums, 0, -1);
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private void dfs(int[] nums, int u, int fa) {
        int t = nums[u];
        for (Integer v : map.get(t)) {
            if (pos[v] == -1) continue;
            if (ans[u] == -1 || dep[ans[u]] < dep[pos[v]]) ans[u] = pos[v];
        }

        int p = pos[t];
        pos[t] = u;
        for (Integer v : g[u]) {
            if (v == fa) {
                continue;
            }
            dep[v] = dep[u] + 1;
            dfs(nums, v, u);
        }
        pos[t] = p;
    }
}