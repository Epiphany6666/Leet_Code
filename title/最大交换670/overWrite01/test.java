package title.最大交换670.overWrite01;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/**
 * 整形转字符串：String.valueOf()
 */

class Solution1 {
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

// method 1：直接遍历
class Solution2 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return maxNum;
    }

    private void swap(char[] charArray, int i, int j) {
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }
}

//method 2：贪心
class Solution {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int[] idx = new int[n];
        for (int i = n - 1, j = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[j]) {
                j = i;
            }
            idx[i] = j;
        }
        for (int i = 0; i < n; i++) {
            if (charArray[idx[i]] != charArray[i]) {
                swap(charArray, i, idx[i]);
                break;
            }
        }
        return Integer.parseInt(new String(charArray));
    }

    private void swap(char[] charArray, int i, int j) {
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }
}