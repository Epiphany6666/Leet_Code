package title.课程表Ⅱ210.overWrite01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 泰裤辣，今天每日一题是这个，昨天就写过了hhha
 * 再写一遍就当复习了叭~
 */
public class test {
}

/*
//TODO 深度优先遍历！
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    int[] ans;
    boolean valid = true;
    int idx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        visited = new int[numCourses];
        ans = new int[numCourses];
        idx = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
            return new int[0];
        }
        return ans;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        ans[idx--] = u;
    }
}*/

//TODO 广度优先遍历！
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] ans = new int[numCourses];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] deg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            deg[info[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int u =  dq.poll();
            ans[idx++] = u;
            for (Integer v : edges.get(u)) {
                deg[v]--;
                if (deg[v] == 0) {
                    dq.offer(v);
                }
            }
        }

        if (idx != numCourses) {
            return new int[0];
        }
        return ans;
    }
}