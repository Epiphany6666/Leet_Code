package title.树节点的第K个祖先1483;

import java.util.Arrays;

public class test {
}

// method 暴力 —— 超时
class TreeAncestor1 {
    private int n;
    private int[] parent;
    public TreeAncestor1(int n, int[] parent) {
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {
        if (node == -1) return -1;
        if (k == 0) return node;
        return getKthAncestor(parent[node], k - 1);
    }
}

/**
 * 参考题解：画图小匠
 */
// method 2：倍增
class TreeAncestor {
    private int Log = 16;
    private int[][] ancestor;
    public TreeAncestor(int n, int[] parent) {
        ancestor = new int[n][Log];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestor[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }
        for (int j = 1; j < Log; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestor[i][j - 1] != -1) {
                    ancestor[i][j] = ancestor[ancestor[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int j = 0;
        while (k != 0) {
            if ((k & 1) != 0) {
                node = ancestor[node][j];
                if (node == -1) {
                    return -1;
                }
            }
            k >>= 1;
            j++;
        }
        return node;
    }
}
