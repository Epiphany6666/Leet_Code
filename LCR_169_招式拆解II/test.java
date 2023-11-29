package title.LCR_169_招式拆解II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
}

//note 没有考虑两端
/*
class Solution {
    public char dismantlingAction(String arr) {
        char[] charArray = arr.toCharArray();
        Arrays.sort(charArray);
        for (int i = 1; i < charArray.length - 1; i++) {
            if (charArray[i - 1] != charArray[i] && charArray[i] != charArray[i + 1]) return charArray[i];
        }
        return ' ';
    }
}*/

/*
//note 还要返回的是第一次只出现一次的字母。。。
class Solution {
    public char dismantlingAction(String arr) {
        char[] charArray = arr.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0 && (charArray.length == 1 || charArray[i + 1] != charArray[i])) return charArray[i];
            if (i > 0 && i < charArray.length - 1 && charArray[i - 1] != charArray[i] && charArray[i] != charArray[i + 1]) return charArray[i];
            if (i == charArray.length - 1 && charArray[i - 1] == charArray[i]) return charArray[i];
        }
        return ' ';
    }
}*/

/*
//hash
class Solution {
    public char dismantlingAction(String arr) {
        char[] ch = new char[26];
        for (char c : arr.toCharArray()) {
            ch[c - 'a']++;
        }
        for (char c : arr.toCharArray()) {
            if (ch[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}*/


//method 大佬的解法
//method 哈希表
/*
class Solution {
    public char dismantlingAction(String arr) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : arr.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : arr.toCharArray()) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}*/

//改写
//note 使用数组，时间和空间都快了一点点
/*class Solution {
    public char dismantlingAction(String arr) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sc = arr.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : sc) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}*/

//method 2：有序哈希表
class Solution {
    public char dismantlingAction(String arr) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] sc = arr.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}