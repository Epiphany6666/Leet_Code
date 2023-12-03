package title.同构字符串205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
}

//mind 还是误解错了。。。不是数量相等，而是完全需要映射
/*class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] cnt1 = new int[128], cnt2 = new int[128];
        for (char c : s.toCharArray()) {
            cnt1[c]++;
        }

        for (char c : t.toCharArray()) {
            cnt2[c]++;
        }

        //note 误解错题目意思了。。
//        Arrays.sort(cnt1);
//        Arrays.sort(cnt2);
//
//        for (int i = 0; i < 128; i++) {
//            if (cnt1[i] != cnt2[i]) return false;
//        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt1[s.charAt(i)] != cnt2[s.charAt(i)]) return false;
        }
        return true;
    }
}*/

/**
 * 参考题解：windliang
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) return false;
            map.put(s.charAt(i), t.charAt(i));
//            char c1 = s.charAt(i), c2 = t.charAt(i);
//            if (map.containsKey(c1)) {
//                if (map.get(c1) != c2) return false;
//            } else {
//                map.put(c1, c2);
//            }
        }
        return true;
    }
}

/**
 * 需要双向映射，所以上面的代码调用两次即可
 */
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) return false;
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}

//method 2：映射成第三方的，映射成的字母为下标
class Solution3 {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];

        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] != mapT[c2]) return false;
            else {
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}