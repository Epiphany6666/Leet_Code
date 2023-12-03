package title.x的平方根69;

public class test {
}

/*
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) < x ? ans + 1 : ans;
    }
}*/

/*
//法2：二分查找
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {//注意越界问题
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}*/

/*
//法3：牛顿迭代法
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return x;
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}*/


//牛顿迭代法自写
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (x0 - xi < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}