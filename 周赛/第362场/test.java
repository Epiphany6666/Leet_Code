package 周赛.第362场;

public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().isReachableAtTime(1, 1, 2, 2, 2));
    }
}

/*
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (List<Integer> num : nums) {
            int l = num.get(0);
            int r = num.get(1);
            for (int i = l; i <= r; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    ans++;
                }
            }
        }
        return ans;
    }
}*/

//TODO 力扣Math.sqrt前面还必须要加(int)才能向下转型。。
/*class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x = Math.abs(sx - fx);
        int y = Math.abs(sy - fy);

        if (x == y && x == 0 && t == 1) return false;

        if (t >= Math.sqrt(x * x + y * y)) return true;
        return false;
    }
}*/
/*class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x = Math.abs(sx - fx);
        int y = Math.abs(sy - fy);

        if (x == y && x == 0 && t == 1) return false;

        double temp = Math.sqrt(x * x + y * y);
        if (t >= temp - 1) return true;
        return false;
    }
}*/

/*
class Solution {
    boolean ans;
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minX = Math.min(sx, fx);
        int maxX = Math.max(sx, fx);
        int minY = Math.min(sy, fy);
        int maxY = Math.max(sy, fy);
        dfs(minX, maxX, minY, maxY, sx, sy, fx, fy, t, 0);
        return ans;
    }

    private void dfs(int minX, int maxX, int minY, int maxY, int sx, int sy, int fx, int fy, int t, int depth) {
        if (sx > maxX && sx < maxX && sy > maxY && sy < minY) return;
        if (sx == fx && sy == fy) {
            if (depth <= t) ans = true;
        }
        for (int i = -1; i <= 1 ; i++) {
            for (int j = -1; j <= 1 ; j++) {
                dfs(minX, maxX, minY, maxY, sx + i, sy + j, fx, fy, t, depth + 1);
            }
        }
    }
}*/

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int v = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        return v == 0 ? (t > 1 || t == 0) : t >= v;
    }
}