package title.重新规划路线1466;

import java.util.*;

/**
 * 这道题可以说真的学到了 有向图如何处理
 */
public class test {
}

/*
class Solution {
    public int minReorder(int n, int[][] connections) {
        //建图
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] c : connections) {
            int x = c[0], y = c[1];
            g[x].add(y);
            g[y].add(x);
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        int ans = 0;
        //用来标记是否访问过
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            //note 这里不是树的遍历啊(#`O′)
            int size = q.size();
            while (size-- > 0) {
                int x = q.poll();
                if (!visited[x]) {
                    visited[x] = true;
                    int a = connections[x][0];
                    int b = connections[x][1];
                    ans += a == x ? 0 : 1;
                    a = a == x ? a : b;
                    q.offer(b);
                }
            }
        }
        return ans;
    }
}*/

/*
class Solution {
    public int minReorder(int n, int[][] connections) {
        //note 我这个建的是无向图！
        //建图
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] c : connections) {
            int x = c[0], y = c[1];
            g[x].add(y);
            g[y].add(x);
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        int ans = 0;
        //用来标记是否访问过
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            for (int idx : g[x]) {
                if (visited[idx]) continue;
                //note 又忘记标记
                visited[idx] = true;
                int a = connections[idx][0];
                int b = connections[idx][1];
                ans += a == x ? 0 : 1;
                //note
//                a = a == x ? a : b;
                a = a == x ? b : a;
                q.offer(b);
            }
        }
        return ans;
    }
}*/


class Solution {
    public int minReorder(int n, int[][] connections) {
        //建图 note 这里记录的是下标
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int[] c = connections[i];
            int x = c[0], y = c[1];
            g[x].add(i);
            g[y].add(i);
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        int ans = 0;
        //用来标记是否访问过
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int x = q.poll();
            //note 这里还不能标记为true，因为下面还需要访问 visited[idx] = true;
//            visited[x] = true;
            for (int idx : g[x]) {
                if (visited[idx]) continue;
                visited[idx] = true;
                int a = connections[idx][0];
                int b = connections[idx][1];
                //note 如果是0 -> 1，才需要加1！
//                ans += a == x ? 0 : 1;
                ans += a == x ? 1 : 0;
                //note a == x的话就需要让b入队列，所以这里应该是把a替换成b！
//                a = a == x ? a : b;
                a = a == x ? b : a;
                q.offer(a);
            }
        }
        return ans;
    }
}