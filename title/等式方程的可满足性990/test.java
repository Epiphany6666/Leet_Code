package title.等式方程的可满足性990;

public class test {
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        Union union = new Union(n);
        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '=') union.Union(equations[i].charAt(0), equations[i].charAt(3));
        }

        for (int i = 0; i < n; i++) {
            String s = equations[i];
            if (s.charAt(1) == '!') {
                int x = union.find(s.charAt(0));
                int y = union.find(s.charAt(3));
                if (x == y) return false;
            }
        }
        return true;
    }

    private class Union {
        private int[] parent;
        public Union(int n) {
            parent = new int[128];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                //路径压缩，迭代
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void Union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            parent[yRoot] = parent[xRoot];
        }
    }
}