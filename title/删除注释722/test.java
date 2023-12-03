package title.删除注释722;

import java.util.ArrayList;
import java.util.List;

/**
 * 总结
 * 1.用boolean值作为标记
 * 2.写if语句时可以分开写
 * 3.记得i++
 */
public class test {
}

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean blockComment = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (blockComment) {
                    if (i + 1 < len && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        blockComment = false;
                        i++;
                    }
                } else {
                    if (i + 1 < len && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        blockComment = true;
                        i++;
                    }
                    else if (i + 1 < len && s.charAt(i) == '/' && s.charAt(i + 1) == '/')
                        break;
                    else
                        sb.append(s.charAt(i));
                }
            }
            if (!blockComment && sb.length() > 0) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }
}