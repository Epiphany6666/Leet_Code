package title.字符串中的单词数434;

public class test {
}
/*
class Solution {
    public int countSegments(String s) {
        String[] str = s.split(" ");
        return str.length;
    }
}
*/

/*
//TODO 没有考虑多个空格的情况
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            if (!flag && ch != ' ') {
                flag = true;
                ans++;
            }
            if (flag && ch == ' ') {
                flag = false;
            }
        }
        return ans;
    }
}*/

//TODO 写法2
//写错了。。。
/*
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ) {
            ans++;
            while (i < n && s.charAt(i) != ' ') i++;
        }
        return ans;
    }
}*/

class Solution {
    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
//            if (s.charAt(i) == ' ' && i++ > 0) continue;
            if (s.charAt(i) == ' ' && i++ >= 0) continue;//是大于等于。。。
            while (i < n && s.charAt(i) != ' ') i++;
            ans++;
        }
        return ans;
    }
}