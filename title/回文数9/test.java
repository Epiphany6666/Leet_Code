
package title.回文数9;

public class test {
    public static void main(String[] args) {
        new Solution().isPalindrome(10);
    }
}

/**
 *总结
 * 看看谈恋爱时写的什么鬼东西。。。
 */
/*
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        StringBuffer s1 = new StringBuffer(s);
        return s.equals(s1.reverse().toString());
    }
}*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
//        while (x <= revertedNumber) {//条件写反了。。。
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}