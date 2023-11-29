package title.斐波那契数509;

public class test {
}

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;//2.又忘记了n <= 1的情况
        int p = 0, q = 1;
//        for (int i = 0; i < n - 2; i++) {
        for (int i = 0; i < n - 1; i++) {//1.
            int r = p + q;
            p = q;
            q = r;
        }
        return q;
    }
}