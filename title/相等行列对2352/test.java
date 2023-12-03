package title.相等行列对2352;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().equalPairs(new int[][] {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}});
    }
}

/*
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] col = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                col[j][i] = grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Arrays.equals(grid[i], col[j]) ? 1 : 0;
            }
        }
        return ans;
    }
}*/

//以下是官方题解
//method 1：模拟
/*
class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (equal(grid, i, j, n)) ans++;
            }
        }
        return ans;
    }

    private boolean equal(int[][] grid, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (grid[i][k] != grid[k][j]) return false;
        }
        return true;
    }
}*/

//method 2：哈希表
//[[11,1],[1,11]]，果然不能以String作为键
/*
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        //note 是真的粗心
//        int n = 0, ans = 0;
        int n = grid.length, ans = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]);
            }
            map.put(row.toString(), map.getOrDefault(row.toString(), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++) {
                col.append(grid[j][i]);
            }
            ans += map.getOrDefault(map.get(col.toString()), 0);
        }
        return ans;
    }
}*/

//除非加分隔符
/*
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length, ans = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j] + " ");
            }
            map.put(row.toString(), map.getOrDefault(row.toString(), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++) {
                col.append(grid[j][i] + " ");
            }
            ans += map.getOrDefault(map.get(col.toString()), 0);
        }
        return ans;
    }
}*/

//使用List集合
//note map.getOrDefault存集合时，如果两个集合里面为相同元素，则只会作为一个元素存！
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0;
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int num : grid[i]) {
                arr.add(num);
            }
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            ans += map.getOrDefault(arr, 0);
        }
        return ans;
    }
}