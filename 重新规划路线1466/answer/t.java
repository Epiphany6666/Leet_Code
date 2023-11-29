package title.重新规划路线1466.answer;

import java.util.*;

public class t {
}

/*
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        //note
        for (int[] uv : connections) {
            graph.get(uv[0]).add(new int[] {uv[1], 1});
            graph.get(uv[1]).add(new int[] {uv[0], 0});
        }

        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] v : graph.get(u)) {
                if (visited[v[0]]) {
                    continue;
                }
                visited[v[0]] = true;
                res += v[1];
                queue.offer(v[0]);
            }
        }

        return res;
    }
}
*/

/*作者：稀有猿诉
        链接：https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solutions/2301538/xi-you-yuan-su-1466-zhong-xin-gui-hua-lu-juiu/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


class Solution {
    public int minReorder(int n, int[][] connections) {
        //note 创建两个，另一个用来判断
        //有向无环图的邻接表
        ArrayList<Integer>[] adj = new ArrayList[n];
        //无向无环图的邻接表
        ArrayList<Integer>[] array = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            array[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            adj[from].add( to );
            array[from].add( to );
            array[to].add( from );
        }
        int[] num = {0};
        boolean[] visited = new boolean[n];
        //从0城市递归往外走，判断路线方向是否需要改变
        dfs(0,array,adj,num,visited);
        return num[0];
    }

    private void dfs( int i, ArrayList<Integer>[] array, ArrayList<Integer>[] adj, int[] num, boolean[] visited ) {
        visited[i] = true;
        ArrayList<Integer> list = array[i];
        for (int j = 0; j < list.size(); j++) {
            Integer k = list.get( j );
            if (visited[k]) {
                continue;
            }
            //如果路线方向与我们走的方向一致 那需要修改
            if (!adj[k].contains( i )) {
                num[0]++;
            }
            dfs( k,array,adj,num, visited );
        }
    }
}

/*
作者：wanpeng
        链接：https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solutions/1346822/by-wp666-c7nx/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

