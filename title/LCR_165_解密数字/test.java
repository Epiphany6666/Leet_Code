package title.LCR_165_解密数字;

public class test {
}

//method 1：动态规划 - 字符串遍历
/**
 * 将整数转化为字符串：String.valueOf()
 */
/*
class Solution {
    public int crackNumber(int ciphertext) {
        String num = String.valueOf(ciphertext);
        int a = 1, b = 1;
        for (int i = 2; i < num.length(); i++) {
            String sb = num.substring(i - 2, i);
            //note 此时应该为b
//            int c = sb.compareTo("10") >= 0 && sb.compareTo("25") <= 0 ? a + b : a;
            int c = sb.compareTo("10") >= 0 && sb.compareTo("25") <= 0 ? a + b : b;
//            a = b;
//            b = c;
            b = a;
            a = c;
        }
//        return b;
        return a;
    }
}*/

//method 对称性
/*
class Solution {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int a = 1, b = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}*/

//method 2：求余运算
class Solution {
    public int crackNumber(int ciphertext) {
        int a = 1, b = 1, x, y = ciphertext % 10;
        while (ciphertext > 9) {
            ciphertext /= 10;
            x = ciphertext % 10;
            int tmp = x * 10 + y;
            int c = tmp >= 10 && tmp <= 25 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}