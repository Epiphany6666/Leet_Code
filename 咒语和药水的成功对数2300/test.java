package title.咒语和药水的成功对数2300;

import java.util.Arrays;

public class test {
}

//method 超时。。。
/*
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        int m = spells.length, n = potions.length;
        for (int i = 0; i < m; i++) {
            int spell = spells[i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (1L * spell * potions[j] >= success) cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}*/

//method 二分查找
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        int m = spells.length, n = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < m; i++) {
            int spell = spells[i];
            ans[i] = (n - binary_search(potions, spell, success));
        }
        return ans;
    }

//    private int binary_search(int[] potions, int spell, long success) {
//        int l = 0, r = potions.length - 1;
//        while (l < r) {
//            int mid = l + ((r - l) >> 1);
//            long num = spell * potions[mid];
//            if (num < success) l = mid + 1;
//            else r = mid;
//        }
//        return l;
//    }

    //note 越界
    private int binary_search(int[] potions, long spell, long success) {
        //note 特判
        if ((long)potions[potions.length - 1] * spell < success) return potions.length;
        int l = 0, r = potions.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            long num = spell * potions[mid];
            if (num < success) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}