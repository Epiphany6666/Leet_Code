package title.数组形式的整数加法989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 我今天才知道List还有这个方法。。。
 * void add(int index, E element);
 * 在此列表中的指定位置插入指定的元素（可选操作）。
 * 将当前位于该位置的元素（如果有）和任何后续元素向右移动（将一个元素添加到其索引中）。
 * 形参： index – 要插入指定元素的索引
 * 元素 – 要插入的元素
 * 抛出： 不支持的操作异常 – 如果此列表不支持添加操作
 */
public class test {
}

/*
//method 越界。。。。
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int ans = 0;
        for (int i : num) {
            ans = ans * 10 + i;
        }
        ans += k;
        List<Integer> list = new ArrayList<>();
        while (ans > 0) {
            list.add(ans % 10);
            ans /= 10;
        }
        Collections.reverse(list);
        return list;
    }
}*/

/*
//method 我的做法思路还是太乱了
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int idx = num.length - 1, cur = 0;
        while (idx >= 0 && (k > 0 || cur > 0)) {
            int t = num[idx] + k % 10 + cur;
            cur = t / 10;
            num[idx--] = t % 10;
            k /= 10;
        }

        List<Integer> ans = new ArrayList<>();
        if (cur > 0) ans.add(cur);
        while (k > 0) {
            ans.add(k % 10);
            k /= 10;
        }
        for (int i : num) {
            ans.add(i);
        }
        return ans;
    }
}*/

//method 这种题已经做过很多道了，为什么还是不会？
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        int sum = 0, cur = 0;
        int idx = n - 1;
        List<Integer> list = new ArrayList<>();
        while (idx >= 0 || k > 0) {
            int n1 = idx >= 0 ? num[idx] : 0;
            int n2 = k > 0 ? k % 10 : 0;
            sum = n1 + n2 + cur;
            cur = sum / 10;
            list.add(0, sum % 10);
        }

        if (cur > 0) list.add(0, cur);
        return list;
    }
}