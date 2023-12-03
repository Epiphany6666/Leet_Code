package title.面试题_16_20_T9键盘;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().getValidT9Words("5722356898", new String[]{"kmkberpjez"});
    }
}

/**
 * .setLength()
 * 设置字符序列的长度。序列将更改为新字符序列，其长度由参数指定。
 * 对于每个小于 newLength 的非负索引 k，如果 k 小于旧字符序列的长度，则新字符序列中索引 k 处的字符与旧序列中索引 k 处的字符相同;否则，它是空字符“\u0000”。换句话说，如果 newLength 参数小于当前长度，则长度将更改为指定的长度。如果 newLength 参数大于或等于当前长度，则会追加足够的空字符 （'\u0000'），以便长度成为 newLength 参数。参数必须大于或等于 0。
 */

class Solution {
    public List<String> getValidT9Words(String num, String[] words) {
        HashMap<Character, Integer> charToIntMap = new HashMap<>();
        charToIntMap.put('a', 2);
        charToIntMap.put('b', 2);
        charToIntMap.put('c', 2);
        charToIntMap.put('d', 3);
        charToIntMap.put('e', 3);
        charToIntMap.put('f', 3);
        charToIntMap.put('g', 4);
        charToIntMap.put('h', 4);
        charToIntMap.put('i', 4);
        charToIntMap.put('j', 5);
        charToIntMap.put('k', 5);
        charToIntMap.put('l', 5);
        charToIntMap.put('m', 6);
        charToIntMap.put('n', 6);
        charToIntMap.put('o', 6);
        charToIntMap.put('p', 7);
        charToIntMap.put('q', 7);
        charToIntMap.put('r', 7);
        charToIntMap.put('s', 7);
        charToIntMap.put('t', 8);
        charToIntMap.put('u', 8);
        charToIntMap.put('v', 8);
        charToIntMap.put('w', 9);
        charToIntMap.put('x', 9);
        charToIntMap.put('y', 9);
        charToIntMap.put('z', 9);

        List<String> ans = new ArrayList<>();
        //mind 我的解法太蠢了，，，
        /*for (String word : words) {
            boolean f = true;
            for (char c : word.toCharArray()) {
                int n = charToIntMap.get(c);
                boolean flag = false;
                for (int i = 0; i < num.length(); i++) {
                    if (n == num.charAt(i) - '0') flag = true;
                }
                if (!flag) f = false;
            }
            if (f) ans.add(word);
        }*/

        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.setLength(0);
            for (char c : word.toCharArray()) {
                sb.append(charToIntMap.get(c));
            }
            if (sb.toString().equals(num)) ans.add(word);
        }
        return ans;
    }
}