package title.重新排列句子中的单词1451;

import java.util.Arrays;
import java.util.Comparator;

public class test {
}

class Solution1 {
    public String arrangeWords(String text) {
        String[] cs = text.split(" ");
        cs[0] = cs[0].toLowerCase();
//        Arrays.sort(cs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() < o2.length()) {
////                    return 1;
//                    return -1;
//                } else {
////                    return -1;
//                    return 1;
//                }
//            }
//        });
        Arrays.sort(cs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
//                    return 1;
                    return -1;
                } else if (o1.length() > o2.length()) {
//                    return -1;
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < cs[0].length(); i++) {
            if (i == 0) {
                s.append(Character.toUpperCase(cs[0].charAt(i)));
            } else {
                s.append(cs[0].charAt(i));
            }
        }
        cs[0] = s.toString();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            sb.append(cs[i] + ' ');
        }
        return sb.toString().trim();
    }
}

/**
 * .split("\\s+")：接着调用字符串的split方法。该方法根据提供的正则表达式作为分隔符将字符串拆分成子字符串数组。在这里，正则表达式 "\\s+" 代表一个或多个连续的空白字符（\s 在正则表达式中表示任何空白字符，加号 + 表示一个或多个前面的元素）。
 */
//method 2：
class Solution2 {
    public String arrangeWords(String text) {
        String[] words = text.trim().split("\\s+");
        if (words.length > 0) {
            words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);
        }
        Arrays.sort(words, Comparator.comparing(String :: length));

        StringBuffer ans = new StringBuffer();
        for (String word : words) {
            ans.append(word + " ");
        }
        if (ans.length() > 0) {
            ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}

class Solution {
    public String arrangeWords(String text) {
        String[] words = text.trim().split("\\s+");
        words[0] = words[0].toLowerCase();
        Arrays.sort(words, Comparator.comparing(String :: length));
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }
}