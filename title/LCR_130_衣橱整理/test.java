package title.LCR_130_衣橱整理;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

//method 1：广度优先遍历
/*
//note 没有标记是否访问过
class Solution {
    public int wardrobeFinishing(int m, int n, int cnt) {
    /note 等于0应该return 1
//        if (cnt == 0) return 0;
        if (cnt == 0) return 1;
        Deque<int[]> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, 1}};
        q.offer(new int[] {0, 0});
        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 2; i++) {
                int x = cur[i] + dir[i][0];
                int y = cur[i] + dir[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n || get(x) + get(y) > cnt) continue;
                q.offer(new int[] {x, y});
                ans++;
            }
        }
        return ans;
    }

    private int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}*/

/*
//method 纠正
class Solution {
    public int wardrobeFinishing(int m, int n, int cnt) {
        if (cnt == 0) return 1;
        Deque<int[]> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 2; i++) {
                int x = cur[i] + dir[i][0];
                int y = cur[i] + dir[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || get(x) + get(y) > cnt) continue;
                q.offer(new int[] {x, y});
                visited[x][y] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}*/


//method 2：递推
class Solution {
    public int wardrobeFinishing(int m, int n, int cnt) {
        if (cnt == 0) return 1;
        int ans = 1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > cnt) continue;
                if (i - 1 >= 0) visited[i][j] |= visited[i - 1][j];
                if (j - 1 >= 0) visited[i][j] |= visited[i][j - 1];
                ans += visited[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}