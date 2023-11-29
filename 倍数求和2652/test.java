package title.倍数求和2652;

public class test {
}

//我居然把丑数那道题和这道题弄混了。。。
/*
class Solution {
    public int sumOfMultiples(int n) {
        int p3 = 1, p5 = 1, p7 = 1;
        int ans = 0;
        for (int i = 1; i <= n && (p3 * 3 <= n || p5 * 5 <= n || p7 * 7 <= n); i++) {
            int n3 = p3 * 3, n5 = p5 * 5, n7 = p7 * 7;
            int pre = Math.min(n3, Math.min(n5, n7));
            ans += pre;
            if (pre == n3) {
                n3++;
                p3 = pre;
            } else if (pre == n5) {
                n5++;
                p5 = pre;
            } else {
                n7++;
                p7 = pre;
            }
        }
        return ans;
    }
}*/

//method 1：枚举
/*
class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            //note 真的很粗心，，，
//            if (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) ans += n;
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) ans += i;
        }
        return ans;
    }
}*/

//method 2：容斥定理
class Solution {
    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

    private int f(int n, int k) {
        int cnt = n / k;
        return (k + cnt * k) * cnt / 2;
    }
}