package title.切披萨的方案数1444;

/**
 * 总结
 * 1.动态规划有「选或不选」和「枚举选哪个」这两种基本思考方式。
 * 2.位运算带括号啊。。。
 */

public class test {
    public static void main(String[] args) {
        String[] pizza = {"A..","AAA","..."};
        new Solution().ways(pizza, 3);
    }
}

/*class Solution {
    public final int Mod = (int)1e9 + 7;
    public int ways(String[] pizza, int k) {
        MatrixSum ms = new MatrixSum(pizza);
        return dfs(k - 1, 0, 0, ms, pizza.length, pizza[0].length());
    }

    private int dfs(int c, int i, int j, MatrixSum ms, int m, int n) {
        if (c == 0) {//递归出口
            return ms.query(i, j, m, n) > 0 ? 1 : 0;
        }
        int ans = 0;
        for (int v = j + 1; v < n; v++) {//垂直切
            if (ms.query(i, j, m, v) > 0) {
                ans = (ans + dfs(c - 1, i, v, ms, m, n)) % Mod;
            }
        }

        for (int f = i + 1; f < m; f++) {
            if (ms.query(i, j, f, n) > 0) {
                ans = (ans + dfs(c - 1, f, j, ms, m, n)) % Mod;
            }
        }
        return ans;
    }
}

class MatrixSum {
    private int[][] sum;

    public MatrixSum(String[] matrix) {
        int m = matrix.length;//行的数量
        int n = matrix[0].length();//列的数量
        sum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i].charAt(j) & 1;
                *//**位运算带括号又不记得？*//*
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
            }
        }
    }

    //计算左上角i，j到右下角m-1,n-1的和
    public int query(int i, int j, int m, int n) {
        return sum[m][n] - sum[m][j] - sum[i][n] + sum[i][j];
    }
}*/

/**记忆化搜索 - 碰到递归一定要想想记忆化搜索。。。*/
/*class Solution {
    public final int Mod = (int)1e9 + 7;
    HashMap<String, Integer> map = new HashMap<>();
    public int ways(String[] pizza, int k) {
        MatrixSum ms = new MatrixSum(pizza);
        return dfs(k - 1, 0, 0, ms, pizza.length, pizza[0].length());
    }

    private int dfs(int c, int i, int j, MatrixSum ms, int m, int n) {
        String key = c + "_" + i + "_" + j;
        if (map.containsKey(key)) return map.get(key);
        if (c == 0) {//递归出口
map.put(key, ms.query(i, j, m, n) > 0 ? 1 : 0);
            return map.get(key);

            return ms.query(i, j, m, n) > 0 ? 1 : 0;
        }
        int ans = 0;
        for (int v = j + 1; v < n; v++) {//垂直切
            if (ms.query(i, j, m, v) > 0) {
                ans = (ans + dfs(c - 1, i, v, ms, m, n)) % Mod;
            }
        }

        for (int f = i + 1; f < m; f++) {
            if (ms.query(i, j, f, n) > 0) {
                ans = (ans + dfs(c - 1, f, j, ms, m, n)) % Mod;
            }
        }
        map.put(key, ans);
        return map.get(key);
    }
}

class MatrixSum {
    private int[][] sum;

    public MatrixSum(String[] matrix) {
        int m = matrix.length;//行的数量
        int n = matrix[0].length();//列的数量
        sum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
            }
        }
    }

    //计算左上角i，j到右下角m-1,n-1的和
    public int query(int i, int j, int m, int n) {
        return sum[m][n] - sum[m][j] - sum[i][n] + sum[i][j];
    }
}*/

//动态规划
class Solution {
    public int ways(String[] pizza, int k) {
        final int Mod = (int) 1e9 + 7;
        MatrixSum ms = new MatrixSum(pizza);
        int m = pizza.length, n = pizza[0].length();
        int[][][] f = new int[k][m][n];
        for (int c = 0; c < k; c++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (c == 0) {
                        f[c][i][j] = ms.query(i, j, m, n) > 0 ? 1 : 0;
                        continue;
                    }
                    int res = 0;
                    for (int j2 = j + 1; j2 < n; j2++)
                        if (ms.query(i, j, m, j2) > 0)
                            res = (res + f[c - 1][i][j2]) % Mod;
                    for (int i2 = i + 1; i2 < m; i2++)
                        if (ms.query(i, j, i2, n) > 0)
                            res = (res + f[c - 1][i2][j]) % Mod;
                    f[c][i][j] = res;
                }
            }
        }
        return f[k - 1][0][0];
    }
}

class MatrixSum {
    int[][] sum;
    public MatrixSum(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
            }
        }
    }

    public int query(int r1, int c1, int r2, int c2) {
        return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
    }
}