package title.按分隔符拆分字符串2788;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().splitWordsBySeparator(new ArrayList<>() {{
            add("$easy$");
            add("$problem$");
        }}, '$');
    }
}

// note 自己写的漏了太多情况了。。。
// 1. i == word.length() - 1
// 2. word.charAt(i) == separator && i == word.length() - 1
class Solution1 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int begin = 0;
            for (int i = 0; i < word.toCharArray().length; i++) {
//                if (word.charAt(i) == separator) {
                if (word.charAt(i) == separator || i == word.length() - 1) {
                    String sub = "";
//                    if (i == word.length() - 1) {
//                        sub = word.substring(begin, i + 1);
//                    } else {
//                        sub = word.substring(begin, i);
//                    }

                    if (word.charAt(i) == separator && i == word.length() - 1) {
                        sub = word.substring(begin, i);
                    } else if (i == word.length() - 1) {
                        sub = word.substring(begin, i + 1);
                    } else {
                        sub = word.substring(begin, i);
                    }
//                    if (sub != "" || sub != " ") ans.add(sub);
                    if (!sub.equals("") && !sub.equals(" ")) ans.add(sub);
                    begin = i + 1;
                }
            }
        }
        return ans;
    }
}

// 或许需要更多次才能把split彻底弄懂
class Solution2 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            // 在Java字符串字面量中，单个反斜杠 \ 需要写成 \\
            // 非前面的分隔符，分割出来的都是""，个数为分隔符个，中间的空字符串为x - 1个，尾部分隔符会自动被裁剪
            String[] strs = word.split("\\" + String.valueOf(separator));
            // 如果是根据空格进行分割，这里分割出来的是x - 1个空字符串，而不是空格，所以只需要判断是不是null或者length是否大于1即可
            for (String str : strs) {
                if (str != null && str.length() >= 1) ans.add(str);
            }
        }
        return ans;
    }
}

//method 3：模拟
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (sb.length() > 0) {
                        ans.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}