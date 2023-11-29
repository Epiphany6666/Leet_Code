package title.强密码检验器Ⅱ;

public class test {
}

/*
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean[] valid = new boolean[5];
        if (password.length() >= 8) valid[0] = true;
        HashSet<Character> set = new HashSet<>();
        String s = "!@#$%^&*()-+";
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        char pre = ' ';
        for (char ch : password.toCharArray()) {
            if (pre == ch) return false;
            pre = ch;
            if (Character.isUpperCase(ch)) valid[2] = true;
            if (Character.isLowerCase(ch)) valid[1] = true;
            if (Character.isDigit(ch)) valid[3] = true;
            if (set.contains(ch)) valid[4] = true;
        }

        for (boolean b : valid) {
            if (!b) return false;
        }
        return true;
    }
}*/

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if (len < 8) return false;

        int mask = 0;
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            if (i != len - 1 && c == password.charAt(i + 1)) {
                return false;
            }
            if (Character.isLowerCase(c)) {
                mask |= 1;
            } else if (Character.isUpperCase(c)) {
                mask |= 2;
            } else if (Character.isDigit(c)) {
                mask |= 4;
            } else {
                mask |= 8;
            }
        }
        return mask == 15;
    }
}