package title.移除最多的同行或同列石头947;

import java.util.HashMap;
import java.util.Map;

/**
 * 总结：
 * 1.为了确保hash表中key与value不同，有三种处理办法（注意题目给的范围是 0 <= xi, yi <= 104 ）：
 *     · key或value加上100001（但为了语义上的清晰，一般选择这种方法）
 *     · key或value减去100001
 *     · key或value~ (取反）
 * 2.并查集只回答连通性的问题，并不回答同属于一个连通分量中的顶点是如何连起来的
 * 3.看完了视频，似懂非懂，但真的大为震撼。
 */

public class test {
}

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            unionFind.Union(x + 10001, y);
        }
        return stones.length - unionFind.count();
    }
}

class UnionFind {
    Map<Integer, Integer> parent;
    int count = 0;
    public int count() {
        return count;
    }

    public UnionFind() {
        parent = new HashMap<>();
    }

    public int Find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            count++;
        }

        if (x != parent.get(x)) {
            parent.put(x, Find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void Union(int x, int y) {
        int rootX = Find(x);
        int rootY = Find(y);

        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
        count--;
    }
}