package title.字母异位词分组49;

import java.util.*;

public class test {
}

//method 1：排序
/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //note 字符数组转化为字符串
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        */
/*List<List<String>> ans  = new ArrayList<>();
        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;*//*

        //note 简写
        return new ArrayList<List<String>>(map.values());
    }
}*/


//method 2：计数
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(i + 'a');
                sb.append(count[i]);
            }
            //note StringBuilder转String两种方式：
//            String key = new String(sb);
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}