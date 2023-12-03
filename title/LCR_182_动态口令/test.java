package title.LCR_182_动态口令;

public class test {
}

/*
class Solution {
    public String dynamicPassword(String password, int target) {
        StringBuffer sb = new StringBuffer();
        for (int i = target; i < password.length(); i++) {
            sb.append(password.charAt(i));
        }
        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }
}*/

//method 2.1：把字符串切片
/*
class Solution {
    public String dynamicPassword(String password, int target) {
        return password.substring(target, password.length()) + password.substring(0, target);
    }
}*/

//method 2.2：利用求余运算，可以简化代码
/*class Solution {
    public String dynamicPassword(String password, int target) {
        StringBuffer sb = new StringBuffer();
        for (int i = target; i < target + password.length(); i++) {
            sb.append(password.charAt(i % password.length()));
        }
        return sb.toString();
    }
}*/

//method 3.1：
class Solution {
    public String dynamicPassword(String password, int target) {
        String ans = "";
        for (int i = target; i < target + password.length(); i++) {
            ans += password.charAt(i % password.length());
        }
        return ans;
    }
}