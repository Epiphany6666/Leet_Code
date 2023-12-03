package title.移除最多的同行或同列石头947.overWrite;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        new Solution().removeStones(stones);
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            uf.union(stone[0] + 10001, stone[1]);
        }

        return stones.length - uf.getCount();
    }
}

class UnionFind {
    HashMap<Integer, Integer> parent = new HashMap<>();
    int count = 0;//统计连通分量

    public int getCount() {
        return count;
    }

    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            count++;
        }

        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if (findX == findY) {
            return;
        }

        parent.put(findX, findY);
        count--;
    }
}