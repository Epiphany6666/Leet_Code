package title.有效的字母异位词242.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 总结：比较了一下这三个的区别
 * Arrays.equals(ch1, ch2); ——  比较数组内容是否相等
 * ch1.equals(ch2); —— 普通的equals就是比较两个对象是否是同一个对象
 * s.equals(t); —— 比较字符串内容是否相等
 *
 * 2.静态代码块作祟
 */

public class test {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(new Solution().isAnagram(s, t));
    }
}

/*class Solution {
    static Map<Character, Integer> hashTable = new HashMap<>();
    static{
        for (char ch = 'a'; ch <= 'z'; ch++) {
            hashTable.put(ch, 0);
        }
    }
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 == n2 && n1 == 0) return true;
        for (char ch : s.toCharArray()) {
            hashTable.put(ch, hashTable.get(ch) + 1);
        }
        for (char ch : t.toCharArray()) {
            hashTable.put(ch, hashTable.get(ch) - 1);
        }
Collection<Integer> values = hashTable.values();
        for (Integer value : values) {
            if (value != 0) return false;
        }

        for (Map.Entry<Character, Integer> entry : hashTable.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}*/

/*//法1：排序
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
}*/

//静态代码块作祟。。。
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hashTable = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            hashTable.put(ch, 0);
        }
        int n1 = s.length();
        int n2 = t.length();
        if (n1 == n2 && n1 == 0) return true;
        for (char ch : s.toCharArray()) {
            hashTable.put(ch, hashTable.get(ch) + 1);
        }
        for (char ch : t.toCharArray()) {
            hashTable.put(ch, hashTable.get(ch) - 1);
        }
        Collection<Integer> values = hashTable.values();
        for (Integer value : values) {
            if (value != 0) return false;
        }

        for (Map.Entry<Character, Integer> entry : hashTable.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}

/*
//法2：哈希表
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alph = new int[26];
        for (char ch : s.toCharArray()) {
            alph[ch - 'a'] ++;
        }
        for (char ch : t.toCharArray()) {
            alph[ch - 'a'] --;
        }
        for (int i : alph) {
            if (i != 0) return false;
        }
        return true;
    }
}*/
