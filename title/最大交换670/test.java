package title.最大交换670;

import java.util.ArrayList;
import java.util.List;

/**
 * list.set()：将此列表中指定位置的元素替换为指定元素（可选操作）。
 * 形参：
 *      index – 要替换的元素的索引
 *      元素 – 要存储在指定位置的元素
 * 返回值：
 *      先前位于指定位置的元素
 */
public class test {
}

class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        int n = list.size();
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }

        for (int i = n - 1; i >= 0; i--) {
//            if (idx[i] != i)
            if (list.get(idx[i]) != list.get(i)) {
                int t = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, t);
                break;
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = ans * 10 + list.get(i);
        }
        return ans;
    }
}
