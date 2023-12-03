package title.一个图中连通三元组的最小度数1761;

public class test {
}

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int ans = 0x3f3f3f3f;
        int len = edges.length;
        /*boolean[][] d = new boolean[len][len];
        int[] deg = new int[len];*/
        boolean[][] d = new boolean[len + 1][len + 1];
        int[] deg = new int[len + 1];

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            d[i][j] = true;
            d[j][i] = true;
            deg[i]++;
            deg[j]++;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                for (int k = 2; k <= n; k++) {
                    if (d[i][j] && d[j][k] && d[k][i]) {
                        ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                    }
                }
            }
        }
        return ans == 0x3f3f3f3f ? -1 : ans;
    }
}