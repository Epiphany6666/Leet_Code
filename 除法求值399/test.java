package title.除法求值399;

import java.util.HashMap;
import java.util.List;

public class test {
}

//method 并查集
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = queries.size();
        double[] ans = new double[size];
        int n = equations.size();
        UnionFind unionFind = new UnionFind(2 * n);
        //note 为了防止hash扩容
        HashMap<String, Integer> map = new HashMap<>(2 * n);
        int id = 0;

        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);
            if (!map.containsKey(x)) map.put(x, id++);
            if (!map.containsKey(y)) map.put(y, id++);
            unionFind.union(map.get(x), map.get(y), values[i]);
        }

        for (int i = 0; i < size; i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) ans[i] = -1.0;
//            else ans[i] = unionFind.find(map.get(x)) / unionFind.find(map.get(y));
            else ans[i] = unionFind.isConnected(map.get(x), map.get(y));
        }
        return ans;
    }

    private class UnionFind {
        int[] parent;
        double[] weight;
        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
//                x = find(parent[x]);
                parent[x] = find(parent[x]);
//                weight[x] *= origin;
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY == rootX) return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY == rootX) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}