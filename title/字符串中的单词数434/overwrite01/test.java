package title.字符串中的单词数434.overwrite01;

public class test {
}

//method 1
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n;) {
            if (s.charAt(i) == ' ' && i++ >= 0) continue;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            ans++;
        }
        return ans;
    }
}