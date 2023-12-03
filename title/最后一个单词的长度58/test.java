package title.最后一个单词的长度58;

public class test {
}

class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && ans != 0) break;
            if (s.charAt(i) == ' ') continue;
            ans++;
        }
        return ans;
    }
}

//method 大佬写法
class Solution2 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        int start = end;
        while (start >= 0 &&  s.charAt(start) != ' ') start--;
        return start - end;
    }
}