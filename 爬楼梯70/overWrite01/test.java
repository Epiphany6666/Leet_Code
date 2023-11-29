package title.爬楼梯70.overWrite01;

public class test {
}

/*
class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p1 = 1, p2 = 2;
        for (int i = 3; i <= n; i++) {
            int t = p1 + p2;
            p1 = p2;
            p2 = t;
        }
        return p2;
    }
}*/

class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 1;
        int p0 = 0, p1 = 0, p2 = 1;
        for (int i = 1; i <= n; i++) {
            p0 = p1;
            p1 = p2;
            p2 = p0 + p1;
        }
        return p2;
    }
}