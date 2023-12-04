package title.验证回文串125;

public class test {
    public static void main(String[] args) {
        String s = "0P";
        new Solution().isPalindrome(s);
    }
}

/**
 * 不能这样，因为s.charAt()随时在改变。。。
 */
//class Solution {
//    public boolean isPalindrome(String s) {
//        s.toLowerCase();
//        int l = 0, r = s.length() - 1;
//        while (l < r) {
//            char cl = s.charAt(l), cr = s.charAt(r);
//            while (cl < 'a' || cl > 'z') l++;
//            while (cr < 'a' || cr > 'z') r--;
//            if (cl != cr) return false;
//            l++;
//            r--;
//        }
//        return true;
//    }
//}

/**
 * 题目都没看清。。
 * s = "0P"
 * 字母和数字都属于字母数字字符...
 *
 * 循环里的判断条件应该是l < r才对
 * 而且s.toLowerCase()的返回值才是转小写的结果
 */
class Solution {
    public boolean isPalindrome(String s) {
//        s.toLowerCase();
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
//            while (s.charAt(l) < 'a' || s.charAt(l) > 'z') l++;
//            while (s.charAt(r) < 'a' || s.charAt(r) > 'z') r--;
            while (l < s.length() && s.charAt(l) < 'a' || s.charAt(l) > 'z') l++;
            while (r >= 0 && s.charAt(r) < 'a' || s.charAt(r) > 'z') r--;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

class Solution2 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !((s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= '0' && s.charAt(l) <= '9'))) l++;
            while (l < r && !((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= '0' && s.charAt(r) <= '9'))) r--;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

/**
 * java居然有专门的api判断
 */
class Solution3 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}