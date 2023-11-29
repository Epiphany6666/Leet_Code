package title.字符串的最大公因子1071;

public class test {
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()) + 1);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    //note 没有考虑0
//    private int gcd(int x, int y) {
//        if (y == 0) return x;
//        while (x / y != 0) {
//            int c = x % y;
//            x = y;
//            y = c;
//        }
//        return y;
//    }
}