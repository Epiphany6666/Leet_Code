package title.建立四叉树427;

public class test {
}

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution1 {
    int[][] g;
    public Node construct(int[][] grid) {
        g = grid;
        int n = grid.length;
        return dfs(0, 0, n - 1, n - 1);
    }

    private Node dfs(int a, int b, int c, int d) {
        boolean ok = true;
        int t = g[a][b];
//        for (int i = a; i <= b; i++) {
        for (int i = a; i <= c && ok; i++) {
//            for (int j = c; j <= d; j++) {
            for (int j = b; j <= d && ok; j++) {
                if (g[i][j] != t) {
                    ok = false;
//                    break;
                }
            }
        }
        if (ok) return new Node(t == 1, true);
        Node root = new Node(t == 1, false);
        int dx = c - a + 1, dy = d - b + 1;
//        root.topLeft = dfs(a, b, a + dx / 2, b + dy / 2);
//        root.topRight = dfs(a + dx / 2, b, a + dx, b + dy / 2);
//        root.bottomLeft = dfs(a, b + dy / 2, a + dx / 2, b +dy);
//        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);

//        note 在计算坐标的时候我犯了一个大错！！！我总是把这里的a误以为是x轴，但其实a是行！！！
//        root.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
//        root.topRight = dfs(a + dx / 2, b, c, b + dy / 2 - 1);
//        root.bottomLeft = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
//        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);

        root.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        root.topRight = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
        root.bottomLeft = dfs(a + dx / 2, b, c, b + dy / 2 - 1);
        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);
        return root;
    }
}

// method 2：前缀和优化
class Solution {
    int[][] g;
    int[][] sum = new int[70][70];
    public Node construct(int[][] grid) {
        g = grid;
        int n = grid.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + g[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n - 1, n - 1);
    }

    private Node dfs(int a, int b, int c, int d) {
        int cur = sum[c + 1][d + 1] - sum[a][d + 1] - sum[b][c + 1] + sum[a][b];
        int dx = c - a + 1, dy = d - b + 1, tot = dx * dy;
        if (cur == 0 || cur == tot) return new Node(g[a][b] == 1, true);
        Node root = new Node(g[a][b] == 1, false);
        root.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        root.topRight = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
        root.bottomLeft = dfs(a + dx / 2, b, c, b + dy / 2 - 1);
        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);
        return root;
    }
}