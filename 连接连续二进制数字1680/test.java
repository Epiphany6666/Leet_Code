package title.连接连续二进制数字1680;

public class test {
}

class Solution {
//    private static final int Mod = (int)10e9 + 7;
    //note 离谱，居然是这里错了。。。
//    private static final int Mod = 1000000007;
//    原来是1e9、、、
private static final int Mod = (int)1e9 + 7;
    public int concatenatedBinary(int n) {
        int res = 0, shift = 0;
        for (int i = 1; i <= n; i++) {
            //判断该数字是否为2的幂次方
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            res = (int)((((long)res << shift) + i) % Mod);
        }
        return res;
    }
}