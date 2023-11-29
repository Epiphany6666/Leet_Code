package title.情侣牵手765;

public class test {
}

class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length / 2;
        UnionFind unionFind = new UnionFind(len / 2);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return len - unionFind.getCount();
    }
}

class UnionFind {
    int[] parent;
    int count = 0;

    public int getCount() {
        return count;
    }

    UnionFind(int x) {
        this.count = x;
        parent = new int[x];
        for (int i = 0; i < x; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        parent[rootA] = rootB;
        count--;
    }
}