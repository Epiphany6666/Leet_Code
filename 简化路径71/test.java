package title.简化路径71;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

/**
 * 查看题解：三叶
 */
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int len = path.length();
        for (int i = 1; i < len; ) {
            if (path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while (j < len && path.charAt(j) != '/') j++;
            String tmp = path.substring(i, j);
            if (tmp.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!tmp.equals(".")) {//note 这里用的巧妙哇
                stack.push(tmp);
            }
            i = j + 1;
        }
        StringBuffer sb = new StringBuffer();
        //note 应该从后往前出
//        for (String s : stack) {
//            sb.append("/" + s);
//        }
        while (!stack.isEmpty()) sb.append("/" + stack.pollFirst());
//        return sb.toString();
        return sb.length() == 0 ? "/" : sb.toString();
    }
}