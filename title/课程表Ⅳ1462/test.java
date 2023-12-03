package title.课程表Ⅳ1462;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class test {
}

/*
//method 深优先遍历
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    StringBuffer sb = new StringBuffer();
    boolean valid = true;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        StringBuffer re = sb.reverse();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int idx1 = re.indexOf(query[0] + "");
            int idx2 = re.indexOf(query[1] + "");
            if (idx1 < 0 || idx2 < 0) ans[i] = false;
            if (idx1 > idx2) ans[i] = true;
            else ans[i] = false;
        }

        List<Boolean> a = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            a.add(ans[i]);
        }
        return a;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if(visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        sb.append(u);
    }
}*/

/*
//method 深优先遍历
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    boolean valid = true;
    boolean[][] isPre;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        visited = new int[numCourses];
        isPre = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
        }

        for (int i = 0; i < numCourses; i++) {
//            if (visited[i] == 0) {
                dfs(i);
//            }
        }

        List<Boolean> an = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            an.add(isPre[query[0]][query[1]]);
        }
        return an;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            isPre[u][v] = true;
            if (visited[v] == 0) {
                dfs(v);

            }
            for (int i = 0; i < isPre.length; i++) {
                isPre[u][i] = isPre[u][i] | isPre[v][i];
            }
        }
    }
}*/


/*
//mind 重写深度优先遍历
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    boolean[] visited;
    boolean[][] isPre;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        isPre = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
        }

        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(isPre[queries[i][0]][queries[i][1]]);
        }
        return ans;
    }

    public void dfs(int u) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        for (Integer v : edges.get(u)) {
            isPre[u][v] = true;
            if (!visited[v]) {
                dfs(v);
            }
            for (int i = 0; i < isPre.length; i++) {
                isPre[u][i] = isPre[u][i] | isPre[v][i];
            }
        }
    }
}*/

//广度优先遍历
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] deg = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
            deg[info[1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (Integer v : edges.get(u)) {
                isPre[u][v] = true;
                for (int i = 0; i < numCourses; i++) {
                    //why?
                    isPre[i][v] = isPre[i][v] | isPre[i][u];
                    // isPre[u][i] = isPre[u][i] | isPre[v][i];
                }
//                if (deg[v]-- == 0) {
                if (--deg[v] == 0) {
                    dq.offer(v);
                }
            }
        }

        for (int[] query : queries) {
            ans.add(isPre[query[0]][query[1]]);
        }
        return ans;
    }
}