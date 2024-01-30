package title.LCR_157_套餐内商品的排列顺序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test {
}

/**
 * 字符数组转字符串：
 * public static String valueOf(char data[])：返回 char 数组参数的字符串表示形式。
 * new String(charArray)
 * charArray.toString()绝对不行！输出的是数组的hash值
 *
 * public static String valueOf(int i)：整数转字符串
 * 字符串转整形：Integer.parseInt
 *
 * List.<T> T[] toArray(T[] a)：
 * 返回一个数组，其中包含此列表中所有元素的正确顺序（从第一个元素到最后一个元素）;返回数组的运行时类型是指定数组的运行时类型。
 */

/*
//mind 我的第一反应是排列，是我想的太复杂了吗，待会再把排列那道题做一遍，对比一下吧
class Solution {
//    String[] ans = new String[];
    List<String> str = new ArrayList<>();
    public String[] goodsOrder(String goods) {
        char[] chars = goods.toCharArray();
        dfs(chars, 0, new ArrayList<>());
        String[] ans = new String[str.size()];
        for (int i = 0; i < str.size(); i++) {
            ans[i] = str.get(i);
        }
        return ans;
    }

    private void dfs(char[] chars, int depth, List<Character> path) {
        if (depth == chars.length) {
            str.add(new ArrayList<>(path));
        }
    }
}
*/

/*
class Solution {
    List<String> ans = new ArrayList<>();
    char[] arr;
    public String[] goodsOrder(String goods) {
        arr = goods.toCharArray();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(int x) {
        if (x == arr.length - 1) {
            ans.add(String.valueOf(arr));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < arr.length; i++) {
            if (!set.add(arr[i])) continue;
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    private void swap(int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}*/

//回溯
class Solution {
    List<String> ans = new ArrayList<>();
    public String[] goodsOrder(String goods) {
        char[] charArray = goods.toCharArray();
        boolean[] used = new boolean[charArray.length];
        Arrays.sort(charArray);
        dfs(charArray, 0, used, new StringBuilder());
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(char[] charArray, int depth, boolean[] used, StringBuilder path) {
        if (depth == charArray.length) {
            ans.add(new String(path));
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (used[charArray[i]]) continue;
//            if (depth > 0 && charArray[depth] == charArray[depth - 1] && !used[depth - 1]) continue;
            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) continue;
            path.append(charArray[i]);
            used[i] = true;
            dfs(charArray, depth + 1, used, path);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}