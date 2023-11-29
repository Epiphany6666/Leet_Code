package title.整数拆分343;

public class test {
    public static void main(String[] args) {

    }
}

/*
class Solution {
    public int integerBreak(int n) {
        int ret = n;
        while (ret != 0) {

            ret /= 10;
        }
    }
}*/

///数学不好。。。
class Solution {
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3;
        int ret = n % 3;
        if (ret == 0)
            return (int)Math.pow(3, a);
        else if (ret == 1)
            return (int)Math.pow(3, a - 1) * 4;
        else
            return (int)Math.pow(3, a) * 2;
    }
}