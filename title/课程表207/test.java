package title.课程表207;

import java.util.*;
/**
 * 总结
 * 1.拓扑排序也分深度和广度遍历
 * 2.图的储存边的结构一般都是List<List<Integer>>，存度的int[]，以后一定要仔细审题
 */

public class test {
    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][] {{0, 1}});
    }
}
/**
 * 总结 我的代码问题出在：
 * 1.没有考虑x == y的情况
 * 2.没有考虑形成环的情况
 */
/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            if (x == y) return false;

            if (map.containsKey(y)) {
                if (map.get(y) == x) return false;
            }
            map.put(x, y);
        }
        return true;
    }
}*/

/**为什么我没有想到拓扑排序呢？？？*/
/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            map.put(x, map.getOrDefault(x, 0));
            map.put(y, map.getOrDefault(y, 0) + 1);
            List<Integer> list = map2.getOrDefault(x, new ArrayList<>());
            list.add(y);
            map2.put(x, list);
        }

        Deque<Integer> dp = new ArrayDeque<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 0) dp.offer(key);
        }

        while (!dp.isEmpty()) {
            int x = dp.poll();
            List<Integer> list = map2.getOrDefault(x, new ArrayList<>());
//            for (Integer i : list) {
            for (int j = 0; j < list.size(); ) {
                int i = list.get(j);
                int y = map.get(i) - 1;
                if (y == 0) {
                    dp.offer(i);
                    list.remove(j);
                } else {
                    j++;
                }
                map.put(i, y);
            }
        }

        for (Integer i : map.values()) {
            if (i > 0) return false;
        }
        return true;
    }
}*/

//深度优先遍历
//好巧妙，真的得学学。。。
/*
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    //boolean没初始化默认false！！！记得初始化啊
//    boolean valid;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        //edges初始化也没写？？
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
//            edges.get(i) = new ArrayList<>();
//            为什么初始化链表你也不会写了？
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            */
/*List<Integer> list = edges.get(info[0]);
            list.add(info[1]);*//*

            edges.get(info[0]).add(info[1]);
        }

        for (int i = 0; valid && i < numCourses; i++) {
//            if (visited[0] == 0) {
            if (visited[i] == 0) {//这个太粗心了！
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
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
    }
}*/


/**
 * 广度优先遍历：
 * 1.题目有给数据范围：0 <= ai, bi < numCourses，为什么不仔细审题呢？哈希表真的很费时间
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] deg = new int[numCourses];
        int visited = 0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //加入edges 并 统计每个结点的度
        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
            deg[info[1]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        /*//如果度为0，就入栈
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                q.offer(i);
                visited++;
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : edges.get(u)) {
                if (--deg[v] == 0) {
                    q.offer(v);
                    visited++;
                }
            }
        }*/

        //写法2：
        //如果度为0，就入栈
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            visited++;//访问一次加一次
            int u = q.poll();
            for (Integer v : edges.get(u)) {
                if (--deg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}