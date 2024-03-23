package title.网格图中最少访问的格子数2617;

import java.util.Arrays;
import java.util.PriorityQueue;

public class test {
}

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]>[] colHeads = new PriorityQueue[n];
//        Arrays.setAll(colHeads, e -> new PriorityQueue<>());
//        PriorityQueue<int[]> rowHead = new PriorityQueue<>();
        Arrays.setAll(colHeads, e -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));
        PriorityQueue<int[]> rowHead = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int f = 0;
        for (int i = 0; i < m; i++) {
            rowHead.clear();
            for (int j = 0; j < n; j++) {
//                while (!rowHead.isEmpty() && rowHead.peek()[0] < i) {
                while (!rowHead.isEmpty() && rowHead.peek()[1] < j) {
                    rowHead.poll();
                }
                PriorityQueue<int[]> colHead = colHeads[j];
//                while (!colHead.isEmpty() && colHead.peek()[0] < j) {
                while (!colHead.isEmpty() && colHead.peek()[1] < i) {
                    colHead.poll();
                }
//                f = i > 1 || j > 1 ? Integer.MAX_VALUE : 1;
                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1;
                int g = grid[i][j];
                if (!rowHead.isEmpty()) {
                    f = rowHead.peek()[0] + 1;
                }
                if (!colHead.isEmpty()) {
                    f = Math.min(f, colHead.peek()[0] + 1);
                }
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowHead.offer(new int[] {f, g + j});
                    colHead.offer(new int[] {f, g + i});
                }
            }
        }
        return f < Integer.MAX_VALUE ? f : -1;
    }
}