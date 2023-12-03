package title.从字符串中移除星号2390;

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class Solution {
    public String removeStars(String s) {
        StringBuffer ans = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            int cnt = 0;
            while (s.charAt(i) == '*') {
                i--;
                cnt++;
            }
            if (cnt != 0) {
                i -= (cnt - 1);
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.reverse().toString();
    }
}*/

//mind 我为啥没有想到栈。。。
class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuffer ans = new StringBuffer();
        while(!stack.isEmpty()) ans.append(stack.pop());
        return ans.toString();
    }
}