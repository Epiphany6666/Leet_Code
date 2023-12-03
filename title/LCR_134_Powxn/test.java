package title.LCR_134_Powxn;

public class test {
}

//method 不出意外，超时
/*
class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if (x < 0) x = 1 / x;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }
}*/

//mind 记得之前做过一次这种题，但今天再做时还是不会。。
class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0d) return 0.0d;
        //note b不为long，取反的时候会越界
//        int b = n;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        double ans = 1.0d;
        while (b > 0) {
            if ((b & 1) != 0) ans *= x;
            x *= x;
            b >>= 1;
        }
        return ans;
    }
}