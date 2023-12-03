package title.H指数_II275;

import java.util.Arrays;

public class test {
}

//method 1：排序
/*
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1, h = 0;
        while (i >= 0 && citations[i] > h) {
            i--;
            h++;
        }
        return h;
    }
}*/

//method 2：排序 + 计数
/*
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length, h = 0;
        //note 数组表示的是引用数有多少篇文章
        int[] cnt = new int[len + 1];
        for (int citation : citations) {
            if (citation > len) cnt[len]++;
            else cnt[citation]++;
        }

        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }
        return -1;
    }
}*/

/*
//method 3：二分查找
class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            int sum = 0;
            for (int citation : citations) {
                if (citation >= mid) sum++;
            }
            if (sum >= mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}*/

//method 3：二分查找 - 利用有序数组的特点
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (citations[mid] >= len - mid) r = mid;
            else l = mid + 1;
        }
        //note [0]这个数据
//        return len - l;
        return citations[l] >= len - l ? len - l : 0;
    }
}