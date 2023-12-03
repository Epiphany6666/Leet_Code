package title.字符串转换整数atoi8;

public class test {
}

class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;
        int i = 0;
        int ans = 0;
        int len = s.length();
        boolean is_negative = false;
        while (i < len && s.charAt(i) == ' ') i++;
        if (i == len) return 0;
        if (s.charAt(i) == '-') is_negative = true;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int tmp = s.charAt(i) - '0';
            //note 少了括号
//            if (!is_negative && ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tmp >= 7)) return Integer.MAX_VALUE;
            if (!is_negative && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tmp >= 7))) return Integer.MAX_VALUE;
//            if (is_negative && ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tmp > 8)) return Integer.MIN_VALUE;
            //note 应该是-ans
//            if (is_negative && -ans < Integer.MIN_VALUE / 10 || (-ans == Integer.MIN_VALUE / 10 && tmp >= 8)) return Integer.MIN_VALUE;
            if (is_negative && (-ans < Integer.MIN_VALUE / 10 || (-ans == Integer.MIN_VALUE / 10 && tmp >= 8))) return Integer.MIN_VALUE;
            ans = ans * 10 + tmp;
            i++;
        }
        if (is_negative) return -ans;
        return ans;
    }
}