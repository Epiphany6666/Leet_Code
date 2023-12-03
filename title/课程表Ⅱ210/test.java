package title.课程表Ⅱ210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 总结
 * 1.不要把size()当做for的变量啊，就不能重新定义一个变量吗？？
 */

public class test {
    public static void main(String[] args) {
        new Solution().findOrder(2, new int[][] {{1, 0}});
    }
}

/**
 * 其实自己写的时候，还是没意识到深度优先遍历的本质，还额外定义了好几个变量
 */
/*
//深度优先遍历
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] deg;
    int[] visited;
    boolean valid = true;
    Deque<Integer> dq = new ArrayDeque<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        deg = new int[numCourses];
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            deg[info[0]]++;
        }

        for (int i = 0; valid && i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[] {};
        }

        //我nia，犯这种低级错误啊，害我检查了好久？？？？？？？
        */
/*for (int i = 0; i < dq.size(); i++) {
                ans[i] = dq.poll();
            }*//*

        int size = dq.size();
        for (int i = 0; i < size; i++) {
            ans[i] = dq.poll();
        }

        return ans;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1)  {
                valid = false;
                return;
            }
        }
        dq.offerFirst(u);
        visited[u] = 2;
    }
}*/

/**重写深度优先遍历拓扑排序*/
/*
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    boolean valid = true;
    int[] ans;
    int idx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //初始化边
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        visited = new int[numCourses];
        ans = new int[numCourses];
        idx = numCourses - 1;

        for (int i = 0; valid && i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
//            return new int[] {};
            return new int[0];//又忘记了这种写法？
        } else {
            return ans;
        }
    }

    private void dfs(int u) {
        //怎么会忘记设置visited？
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


/**广度优先遍历*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] deg = new int[numCourses];
        int idx = 0;
        int[] ans = new int[numCourses];
//        int visited = 0;

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            deg[info[0]]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int u = dq.poll();
//            visited++;
            ans[idx++] = u;
            for (Integer v : edges.get(u)) {
                deg[v]--;
                if (deg[v] == 0) dq.offer(v);
            }
        }

//        if (visited != numCourses) {
        //这里不是已经有了idx索引了吗！！！？？？为什么还要再创一个？？？能不能动点脑子啊。
        if (idx != numCourses) {
            return new int[0];
        } else {
            return ans;
        }
    }
}