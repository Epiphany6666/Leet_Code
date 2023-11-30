package title.单词规律290;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(new Solution().wordPattern(pattern, s));
    }
}

/**
 * 服了，一开始题目意思都没读懂
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] ss = s.split(" ");
        int idx1 = 0, idx2 = 0;
        Map<Character, String> map = new HashMap<>();
        while (idx1 < p.length && idx2 < ss.length) {
//            while (ss[idx2] == " ") idx2++;
            while (ss[idx2].equals(" ")) idx2++;
            if (map.containsKey(p[idx1])) {
                //note 1.太粗心了 2.比较字符串应该使用equals！！！
//                if (ss[idx2] != map.get(p[idx1])) return false;
//                if (ss[idx2].equals(map.get(p[idx1]))) return false;
                if (!ss[idx2].equals(map.get(p[idx1]))) return false;
            } else {
                map.put(p[idx1], ss[idx2]);
            }
            idx1++;
            idx2++;
        }
        if (idx1 != p.length || idx2 != ss.length) return false;
        return true;
    }
}

/**
 * 好好好，这样玩是吧pattern = "abba"， s = "dog dog dog dog"
 */
class Solution2 {
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] ss = s.split(" ");
        int idx1 = 0, idx2 = 0;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        while (idx1 < p.length && idx2 < ss.length) {
//            while (ss[idx2] == " ") idx2++;
            while (ss[idx2].equals(" ")) idx2++;
            if (map.containsKey(p[idx1])) {
//                if (ss[idx2] != map.get(p[idx1])) return false;
                if (ss[idx2].equals(map.get(p[idx1]))) return false;
            } else {
                if (map2.containsKey(ss[idx2]) && map2.get(ss[idx2]) != p[idx1]) return false;
                map.put(p[idx1], ss[idx2]);
                map2.put(ss[idx2], p[idx1]);
            }
            idx1++;
            idx2++;
        }
        if (idx1 != p.length || idx2 != ss.length) return false;
        return true;
    }
}

/**
 * 1.注意题目有说：s中每个单词都被 单个空格 分隔
 * 2.Map.put方法：与 key 关联的上一个值，如果没有 key 的映射，则为 null。
 * 3.这个方法真的太巧秒了吧。。。
 * 4.这个注意，循环中只能使用Integer，因为自动装箱使用的是Integer.valueOf(int i)方法。
 *   int值在[-128,127]范围内是使用缓存中的对象，超过这个范围就创建新的Integer对象。
 */
class Solution3 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = pattern.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Object, Integer> map = new HashMap<>();
//        for (int i = 0; i < pattern.length(); i++) {
        for (Integer i = 0; i < pattern.length(); i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) return false;
        }
        return true;
    }
}